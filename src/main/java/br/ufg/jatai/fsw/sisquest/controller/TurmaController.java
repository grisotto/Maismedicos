/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.sisquest.controller;

import br.ufg.jatai.fsw.sisquest.annotations.Permissao;
import br.ufg.jatai.fsw.sisquest.facade.TurmaFacade;
import br.ufg.jatai.fsw.sisquest.model.Aluno;
import br.ufg.jatai.fsw.sisquest.model.Tarefa;
import br.ufg.jatai.fsw.sisquest.model.Turma;
import br.ufg.jatai.fsw.sisquest.model.Usuario;
import br.ufg.jatai.fsw.sisquest.service.AlunoService;
import br.ufg.jatai.fsw.sisquest.service.TurmaService;
import java.io.Serializable;
import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author dfranco
 */
@Controller
public class TurmaController implements Serializable {

    private static Logger log = LoggerFactory.getLogger(TurmaController.class.getName());
    private static final long serialVersionUID = -2178567604078375167L;

//    @Autowired
//    private TurmaService tService;
    @Autowired
    private AlunoService aService;

    @Autowired
    private TurmaFacade facade;

    /**
     *
     * @return
     */
    @Permissao(Usuario.TipoUsuario.PROFESSOR)
    @RequestMapping(value = "/app/turma")
    public String turmaHome(final Turma turma) {
        return "/app/turma/home";
    }

    @PostMapping(value = "/app/turma", params = {"save"})
    public String saveTurma(@Valid final Turma turma, final BindingResult bindingResult, final ModelMap model) {
//        bindingResult.addError(new ObjectError("Deu erro", "Deu erro"));
        if (bindingResult.hasErrors()) {
            model.addAttribute("turma", turma);
            return "/app/turma/home";
        }
        facade.createTurma(turma);
        model.clear();
        return "redirect:/app/turma";
    }

    @ModelAttribute("allTurmas")
    public List<Turma> populateVisualizarTurma() {
        return facade.turmasOfProfessor();

    }

    @GetMapping(value = "/app/turma/{id}")
    public String showTurma(@PathVariable Integer id, ModelMap map) {

        map.addAttribute("turma", facade.findTurma(id));

//        map.addAttribute("turma", tService.find(id));
//        map.addAttribute("alunos", tService.find(id).getAlunos());
//        map.addAttribute("tarefas", tService.find(id).getTarefas());
        //NUNCA MAIS FAZ ISSO DYEIMYS
        map.addAttribute("todosAlunos", aService.findAll());

        return "/app/turma/show";
    }

     @ModelAttribute("todasTarefas")
    public List<Tarefa> todasTarefas() {
        return facade.tarefasOfProfessor();
    }

    @PostMapping(value = "/app/turma/add/aluno", params = {"save"})
    public String adicionarAuluno(@Valid Integer turmaID, @Valid Integer alunoID, ModelMap map) {
        System.out.println("ENTROU AQUI");
        Turma insertAluno = facade.insertAluno(turmaID, alunoID);

        map.addAttribute("turma", insertAluno);

        return "redirect:/app/turma/" + turmaID;

    }
}
