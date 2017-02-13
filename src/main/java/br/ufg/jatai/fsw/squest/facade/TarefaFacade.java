package br.ufg.jatai.fsw.squest.facade;

import br.ufg.jatai.fsw.squest.AutenticateUser;
import br.ufg.jatai.fsw.squest.controller.modelForm.EtapasModel;
import br.ufg.jatai.fsw.squest.domain.*;
import br.ufg.jatai.fsw.squest.domain.quis.QuestaoQuiz;
import br.ufg.jatai.fsw.squest.domain.quis.Quiz;
import br.ufg.jatai.fsw.squest.domain.quis.RespotaQuestaoQuiz;
import br.ufg.jatai.fsw.squest.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by dyeimys on 06/01/17.
 */
@Component
public class TarefaFacade {

    @Autowired
    private TarefaService tarefaService;
    @Autowired
    private TurmaService turmaService;

    @Autowired
    private QuestaoService questaoService;

    @Autowired
    private QuizService quizService;

    @Autowired
    private AutenticateUser autenticateUser;

    @Autowired
    private RespotaQuestaoQuizService respotaQuestaoQuizService;

    private static final Logger LOGGER = LoggerFactory.getLogger(TarefaFacade.class);

    /**
     * Persite uma tarefa
     *
     * @param tarefa
     * @return
     */
    public Tarefa saveTarefa(Tarefa tarefa) {
        return tarefaService.inserir(tarefa);
    }

    /**
     * Listagem das Tarefas cafastras com o professor autenticado.
     *
     * @return
     */
    public List<Tarefa> tarefasFromProessorAuth() {
        return this.tarefaService.allOfProfessor(autenticateUser.getProfessor());

    }

    /**
     * Lista todas as tumas cadastradas no sistma pelo professor ativo
     *
     * @return
     */
    public List<Turma> todasTurmas() {
        return this.turmaService.allOfProfessor(autenticateUser.getProfessor());

    }

    /**
     * Busca por uma turma respectiva pelo ID
     *
     * @param tarefaID id da tarefa
     * @return
     */
    public Tarefa findTarefa(Integer tarefaID) {
        return tarefaService.find(tarefaID);

    }

    /**
     *
     * @param idTarefa
     * @param etapasModel
     */
    public void atualizaDatasEtapas(Integer idTarefa, EtapasModel etapasModel){
        Tarefa find = tarefaService.find(idTarefa);
//        find.getEtapaEventos().clear();
        find.setEtapaAtual(etapasModel.getAguardando());
        find.getEtapaEventos().addAll(etapasModel.buildeLista());

        tarefaService.atualizar(find);
    }
    

    @Autowired
    EtapaEventoService etapaEventoService;

    public void atualizaEtapaAtual(Integer idTarefa, Integer idEtapa) {
        Tarefa tarefa = tarefaService.find(idTarefa);
        EtapaEvento etapaEvento = etapaEventoService.find(idEtapa);
        tarefa.setEtapaAtual(etapaEvento);
        
        tarefaService.atualizar(tarefa);
        
        
    }

    public void criarQuiz (Integer tarefaID){

        Tarefa tarefa = tarefaService.find(tarefaID);//Recuprar a tarefa
        Quiz q = new Quiz();//Inicializa o quiz
        q.setTarefa(tarefa);//Coloca Tarefa
        Set<Questao> questoes = questaoService.questoesParaQuiz(tarefaID);//Recupera as questões
        q.setQuestaoQuizes(QuestaoQuiz.AjusteTecnico.create(questoes));//Coloca questões

        quizService.inserir(q);//Salva quiz


    }

    /**
     * Calculando o fator 1
     * @param fator1
     * @param taredaID
     * @return
     */
    public void calculoFator1(double fator1, Integer taredaID) {
        int quantidadeAprovadas = 0;
       Tarefa tarefa = tarefaService.find(taredaID);

       tarefa.setFator1(fator1);

       //pego todas as equipes da tarefa
        Iterator<Equipe> i = tarefa.getEquipes().iterator();


        while(i.hasNext()){

            Equipe e = i.next();

            //verifico se ela esta ativa
            if(e.isAtiva()){
                //pego todas as questoes desta equipe
                List<Questao> q = e.getQuestionario().getQuestoes();
                //por todas as questoes, passado aumentando a quantidade de validas.
                for(Questao questao : q){
                    if(questao.isAprovada()){
                        quantidadeAprovadas++;
                    }
                }
                //fica pegando as alternativas tambem, muito chato isso, por isso preciso dividir
                quantidadeAprovadas/= 30;

                e.setPontosFator1(quantidadeAprovadas * fator1);

            }
            quantidadeAprovadas = 0;



        }

    }


    public void calculoFator2(double fator2, Integer taredaID) {

        int quantidadeCorretas =0;
        Tarefa tarefa = tarefaService.find(taredaID);

        tarefa.setFator2(fator2);


        //pego todas as equipes da tarefa
        Iterator<Equipe> i = tarefa.getEquipes().iterator();


        while(i.hasNext()){

            Equipe e = i.next();

            //verifico se ela esta ativa
            if(e.isAtiva()){
                //pego todas as questoes respondidas desta equipe
        List<RespotaQuestaoQuiz> respotaQuestaoQuizs =  respotaQuestaoQuizService.findAllByEquipe_Id(e.getId());

                //por todas as questoes respondidas, passado aumentando a quantidade de corretas.
                for(RespotaQuestaoQuiz questoes : respotaQuestaoQuizs){
                    if(questoes.getAlternativa().isCorreto()){
                        quantidadeCorretas++;
                    }
                }
               e.setPontosFator2(quantidadeCorretas * fator2);

            }
            quantidadeCorretas = 0;



        }



        //para cada equipe ativa da tarefa
            //para todas as questoes que a equipe tinha que responder
                //contar quantas ela acertou
                //multiplicar pelo fator2
                //salvar no equipePontosFator2 o resultado





    }

    public void calculoFator3(double fator3, Integer taredaID) {

        double somaPorcentagemDificuldades = 0.00;
        double somaRespostaErradas = 0.00;
        Tarefa tarefa = tarefaService.find(taredaID);

        tarefa.setFator3(fator3);

        //pego todas as equipes da tarefa
        Iterator<Equipe> i = tarefa.getEquipes().iterator();

        //pego todas as questoes do quiz
        Set<QuestaoQuiz> todas = quizService.find(tarefa.getQuiz().getId()).getQuestaoQuizes();

        while(i.hasNext()){

            Equipe e = i.next();

            //verifico se ela esta ativa
            if(e.isAtiva()){
                //por todas as questoes do quiz
                for(QuestaoQuiz questoes : todas){
                    //verifico se esta questao que estou olhando eh da equipe
                    if(questoes.getEquipe().equals(e)){

                        List<RespotaQuestaoQuiz> respostaParaQuestao = respotaQuestaoQuizService.findAllByQuestao_Id(questoes.getQuestao().getId());
//                        LOGGER.info("respostaParaQuestao.size: "+respostaParaQuestao.size()
//                                +" Equipe: " + e.getNome()
//                                +" QuestaoID " + questoes.getQuestao().getId()
//                                +" Questao: " + questoes.getQuestao().getQuestion()
//
//                        );

                        for (RespotaQuestaoQuiz respostas : respostaParaQuestao){
                            if(!respostas.getAlternativa().isCorreto()){
                                somaRespostaErradas++;
                            }
                        }



                        //depois que ele tem a quantidade de pessoas que erram
                        //pode colocar para o fator multiplicar cada questao. Da valor para a questao
//                        LOGGER.info("somaPorcentagemDificuldadesANTES: "+somaPorcentagemDificuldades



                        somaPorcentagemDificuldades = (somaRespostaErradas / respostaParaQuestao.size() * fator3) + somaPorcentagemDificuldades;

                                somaRespostaErradas = 0.00;
                    }
                }


                e.setPontosFator3(somaPorcentagemDificuldades);


            }

            somaPorcentagemDificuldades = 0;



        }

        //para cada equipe ativa da tarefa
            //para todas as questoes que a equipe inseriu que foram aprovadas
                //calcular a % de erro -
                //exemplo1 - 4 equipes erraram de 6, entao 0,666 taxa de erro
                //multiplicar o fator3 com cada taxa de erro de cada questao
                //somar de todas as questoes e salvar no equipePontosfator3 o resultado



        //        for(Equipe e : equipeResponderam){
//            if(e.getId().equals(equipeID)){
//                return true;
//            }
//
//        }





    }

}
