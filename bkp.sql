-- MySQL dump 10.15  Distrib 10.0.23-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: sisQuest
-- ------------------------------------------------------
-- Server version	10.0.23-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `SPRING_SESSION`
--

DROP TABLE IF EXISTS `SPRING_SESSION`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SPRING_SESSION` (
  `SESSION_ID` char(36) NOT NULL DEFAULT '',
  `CREATION_TIME` bigint(20) NOT NULL,
  `LAST_ACCESS_TIME` bigint(20) NOT NULL,
  `MAX_INACTIVE_INTERVAL` int(11) NOT NULL,
  `PRINCIPAL_NAME` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`SESSION_ID`),
  KEY `SPRING_SESSION_IX1` (`LAST_ACCESS_TIME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SPRING_SESSION`
--

LOCK TABLES `SPRING_SESSION` WRITE;
/*!40000 ALTER TABLE `SPRING_SESSION` DISABLE KEYS */;
INSERT INTO `SPRING_SESSION` VALUES ('f7b9d7bb-6d99-4e97-8980-3ee3f58e3374',1484000742481,1484000942268,1800,'professor');
/*!40000 ALTER TABLE `SPRING_SESSION` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SPRING_SESSION_ATTRIBUTES`
--

DROP TABLE IF EXISTS `SPRING_SESSION_ATTRIBUTES`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SPRING_SESSION_ATTRIBUTES` (
  `SESSION_ID` char(36) NOT NULL DEFAULT '',
  `ATTRIBUTE_NAME` varchar(200) NOT NULL DEFAULT '',
  `ATTRIBUTE_BYTES` blob,
  PRIMARY KEY (`SESSION_ID`,`ATTRIBUTE_NAME`),
  KEY `SPRING_SESSION_ATTRIBUTES_IX1` (`SESSION_ID`),
  CONSTRAINT `SPRING_SESSION_ATTRIBUTES_FK` FOREIGN KEY (`SESSION_ID`) REFERENCES `SPRING_SESSION` (`SESSION_ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SPRING_SESSION_ATTRIBUTES`
--

LOCK TABLES `SPRING_SESSION_ATTRIBUTES` WRITE;
/*!40000 ALTER TABLE `SPRING_SESSION_ATTRIBUTES` DISABLE KEYS */;
INSERT INTO `SPRING_SESSION_ATTRIBUTES` VALUES ('f7b9d7bb-6d99-4e97-8980-3ee3f58e3374','SPRING_SECURITY_CONTEXT','¬í\0sr\0=org.springframework.security.core.context.SecurityContextImpl\0\0\0\0\0\0š\0L\0authenticationt\02Lorg/springframework/security/core/Authentication;xpsr\0Oorg.springframework.security.authentication.UsernamePasswordAuthenticationToken\0\0\0\0\0\0š\0L\0credentialst\0Ljava/lang/Object;L\0	principalq\0~\0xr\0Gorg.springframework.security.authentication.AbstractAuthenticationTokenÓª(~nGd\0Z\0\rauthenticatedL\0authoritiest\0Ljava/util/Collection;L\0detailsq\0~\0xpsr\0&java.util.Collections$UnmodifiableListü%1µìŽ\0L\0listt\0Ljava/util/List;xr\0,java.util.Collections$UnmodifiableCollectionB\0€Ë^÷\0L\0cq\0~\0xpsr\0java.util.ArrayListxÒ™Ça\0I\0sizexp\0\0\0w\0\0\0~r\02br.ufg.jatai.fsw.squest.domain.Usuario$TipoUsuario\0\0\0\0\0\0\0\0\0\0xr\0java.lang.Enum\0\0\0\0\0\0\0\0\0\0xpt\0	PROFESSORxq\0~\0\rsr\0Horg.springframework.security.web.authentication.WebAuthenticationDetails\0\0\0\0\0\0š\0L\0\rremoteAddresst\0Ljava/lang/String;L\0	sessionIdq\0~\0xpt\0	127.0.0.1t\0$7906d707-f491-4ffd-a3e6-a3f9a0ba95a2psr\0Abr.ufg.jatai.fsw.squest.SecurityUserService$RepositoryUserDetailséäô²¹}âú\0\0xr\0&br.ufg.jatai.fsw.squest.domain.Usuariouºò\riY!,\0L\0equipet\0\'Lbr/ufg/jatai/fsw/squest/domain/Equipe;L\0idt\0Ljava/lang/Integer;L\0loginq\0~\0L\0	professort\0*Lbr/ufg/jatai/fsw/squest/domain/Professor;L\0senhaq\0~\0L\0tipoUsuariot\04Lbr/ufg/jatai/fsw/squest/domain/Usuario$TipoUsuario;xppsr\0java.lang.Integerâ ¤÷‡8\0I\0valuexr\0java.lang.Number†¬•”à‹\0\0xp\0\0\0t\0	professorsr\0(br.ufg.jatai.fsw.squest.domain.Professor{.%ÃáÝë\0L\0emailq\0~\0L\0turmasq\0~\0	L\0usuariot\0(Lbr/ufg/jatai/fsw/squest/domain/Usuario;xr\0%br.ufg.jatai.fsw.squest.domain.Pessoa¬†6$Ò%Kz\0L\0idq\0~\0\ZL\0nomeq\0~\0xpsq\0~\0\0\0\0t\0Professor Algustot\0professor@email.comsr\0/org.hibernate.collection.internal.PersistentBagFJd\\.Ä\0L\0bagq\0~\0	xr\0>org.hibernate.collection.internal.AbstractPersistentCollectionbt\0Ð_Us<\0\nZ\0allowLoadOutsideTransactionI\0\ncachedSizeZ\0dirtyZ\0initializedZ\0\risTempSessionL\0keyt\0Ljava/io/Serializable;L\0ownerq\0~\0L\0roleq\0~\0L\0sessionFactoryUuidq\0~\0L\0storedSnapshotq\0~\0+xp\0ÿÿÿÿ\0\0\0q\0~\0&q\0~\0%t\0/br.ufg.jatai.fsw.squest.domain.Professor.turmaspppsq\0~\0pq\0~\0 q\0~\0!q\0~\0%t\0<$2a$10$6mLgJvpknvvvdXsN3FQwyOwgNKpKxHNwf9x0ZL.R.ob9x7c6sBr7uq\0~\0q\0~\0/q\0~\0');
/*!40000 ALTER TABLE `SPRING_SESSION_ATTRIBUTES` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alternativa`
--

DROP TABLE IF EXISTS `alternativa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alternativa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `correto` bit(1) NOT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `questao_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1r2gwu4bd0jnmah9m5401qex5` (`questao_id`),
  CONSTRAINT `FK1r2gwu4bd0jnmah9m5401qex5` FOREIGN KEY (`questao_id`) REFERENCES `questao` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alternativa`
--

LOCK TABLES `alternativa` WRITE;
/*!40000 ALTER TABLE `alternativa` DISABLE KEYS */;
/*!40000 ALTER TABLE `alternativa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `aluno`
--

DROP TABLE IF EXISTS `aluno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aluno` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `matricula` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_3wpes15e0anbfaa4do0pey97k` (`email`),
  UNIQUE KEY `UK_prosr3jo55p8vlcu7e0g7s2ov` (`matricula`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aluno`
--

LOCK TABLES `aluno` WRITE;
/*!40000 ALTER TABLE `aluno` DISABLE KEYS */;
INSERT INTO `aluno` VALUES (1,'JosÃ© Antonio','jose@email.com','1245'),(2,'Maria JosÃ©','maria@email.com','12469'),(3,'Pesro Silva','pedro@email.com','9438'),(4,'Aparecida Antonio','aparecida@email.com','63853'),(5,'Rafael Grisotto','rafael@grisotto.com','2012922'),(6,'Ana Laura Gomes','vVKPnAIZCWbWsG@dkimvalidator.com','2015621'),(7,'AndrÃ© Vieria','ana@ana.com','12312'),(8,'Gustavo','gustavo@hu.com','122312');
/*!40000 ALTER TABLE `aluno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_of_birth` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipe`
--

DROP TABLE IF EXISTS `equipe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equipe` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ativa` bit(1) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `tarefa_id` int(11) DEFAULT NULL,
  `usuario_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKg9dqtc3itum61queasgfk6md8` (`tarefa_id`),
  KEY `FK9hidlfrbwe0glhphkdt5htu9v` (`usuario_id`),
  CONSTRAINT `FK9hidlfrbwe0glhphkdt5htu9v` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`),
  CONSTRAINT `FKg9dqtc3itum61queasgfk6md8` FOREIGN KEY (`tarefa_id`) REFERENCES `tarefa` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipe`
--

LOCK TABLES `equipe` WRITE;
/*!40000 ALTER TABLE `equipe` DISABLE KEYS */;
INSERT INTO `equipe` VALUES (1,'\0','BETA',1,3);
/*!40000 ALTER TABLE `equipe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipe_alunos`
--

DROP TABLE IF EXISTS `equipe_alunos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equipe_alunos` (
  `equipes_id` int(11) NOT NULL,
  `alunos_id` int(11) NOT NULL,
  KEY `FKdkjmlx3lwgae4u42hatgu8e24` (`alunos_id`),
  KEY `FKpp1enon3p3aeweyo5ilw7vxi3` (`equipes_id`),
  CONSTRAINT `FKdkjmlx3lwgae4u42hatgu8e24` FOREIGN KEY (`alunos_id`) REFERENCES `aluno` (`id`),
  CONSTRAINT `FKpp1enon3p3aeweyo5ilw7vxi3` FOREIGN KEY (`equipes_id`) REFERENCES `equipe` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipe_alunos`
--

LOCK TABLES `equipe_alunos` WRITE;
/*!40000 ALTER TABLE `equipe_alunos` DISABLE KEYS */;
INSERT INTO `equipe_alunos` VALUES (1,6);
/*!40000 ALTER TABLE `equipe_alunos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `etapa_evento`
--

DROP TABLE IF EXISTS `etapa_evento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `etapa_evento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data_final` datetime DEFAULT NULL,
  `data_inicial` datetime DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `etapa_evento`
--

LOCK TABLES `etapa_evento` WRITE;
/*!40000 ALTER TABLE `etapa_evento` DISABLE KEYS */;
INSERT INTO `etapa_evento` VALUES (1,'2017-01-16 20:28:00','2017-01-09 20:28:00','AGUARDANDO'),(2,'2017-01-16 20:28:00','2017-01-16 20:28:00','ESPERANDO_SUBMISSAO'),(3,'2017-01-16 20:28:00','2017-01-16 20:28:00','RESPONDENDO'),(4,'2017-01-23 20:28:00','2017-01-16 20:28:00','VALIDANDO_QUESTOES'),(5,'2017-01-25 20:28:00','2017-01-16 20:28:00','FINALIZADO');
/*!40000 ALTER TABLE `etapa_evento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `professor`
--

DROP TABLE IF EXISTS `professor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `professor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `usuario_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_qjm28ojevoom770jyieljec3e` (`email`),
  KEY `FKeb8b0ngr9yvkq845hsoadqmmy` (`usuario_id`),
  CONSTRAINT `FKeb8b0ngr9yvkq845hsoadqmmy` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `professor`
--

LOCK TABLES `professor` WRITE;
/*!40000 ALTER TABLE `professor` DISABLE KEYS */;
INSERT INTO `professor` VALUES (1,'Professor Algusto','professor@email.com',2);
/*!40000 ALTER TABLE `professor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `questao`
--

DROP TABLE IF EXISTS `questao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `questao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question` varchar(255) DEFAULT NULL,
  `questionario_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4fxjxhw4xawsmeadp35w2xdwp` (`questionario_id`),
  CONSTRAINT `FK4fxjxhw4xawsmeadp35w2xdwp` FOREIGN KEY (`questionario_id`) REFERENCES `questionario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questao`
--

LOCK TABLES `questao` WRITE;
/*!40000 ALTER TABLE `questao` DISABLE KEYS */;
/*!40000 ALTER TABLE `questao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `questionario`
--

DROP TABLE IF EXISTS `questionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `questionario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tarefa_id` int(11) DEFAULT NULL,
  `time_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKk3bwwo6t2agnihs4gc8bblbv2` (`tarefa_id`),
  KEY `FKq3o36aq04pvq9faqw1kiy60fi` (`time_id`),
  CONSTRAINT `FKk3bwwo6t2agnihs4gc8bblbv2` FOREIGN KEY (`tarefa_id`) REFERENCES `tarefa` (`id`),
  CONSTRAINT `FKq3o36aq04pvq9faqw1kiy60fi` FOREIGN KEY (`time_id`) REFERENCES `equipe` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questionario`
--

LOCK TABLES `questionario` WRITE;
/*!40000 ALTER TABLE `questionario` DISABLE KEYS */;
/*!40000 ALTER TABLE `questionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tarefa`
--

DROP TABLE IF EXISTS `tarefa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tarefa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) DEFAULT NULL,
  `tamanho_questoes` int(11) DEFAULT NULL,
  `titulo` varchar(255) DEFAULT NULL,
  `etapa_atual_id` int(11) DEFAULT NULL,
  `turma_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK77q9kvd6q29ph273mogm246g` (`etapa_atual_id`),
  KEY `FK58pdx5t5i6hxpvq8dhu6y4osu` (`turma_id`),
  CONSTRAINT `FK58pdx5t5i6hxpvq8dhu6y4osu` FOREIGN KEY (`turma_id`) REFERENCES `turma` (`id`),
  CONSTRAINT `FK77q9kvd6q29ph273mogm246g` FOREIGN KEY (`etapa_atual_id`) REFERENCES `etapa_evento` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tarefa`
--

LOCK TABLES `tarefa` WRITE;
/*!40000 ALTER TABLE `tarefa` DISABLE KEYS */;
INSERT INTO `tarefa` VALUES (1,'Muita coisa acontecendo nesta cidade',5,'Atividade primeiro semestre',1,1);
/*!40000 ALTER TABLE `tarefa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tarefa_etapa_eventos`
--

DROP TABLE IF EXISTS `tarefa_etapa_eventos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tarefa_etapa_eventos` (
  `tarefas_id` int(11) NOT NULL,
  `etapa_eventos_id` int(11) NOT NULL,
  PRIMARY KEY (`tarefas_id`,`etapa_eventos_id`),
  KEY `FK1qayvy3glc0bccx4opfhfnk0v` (`etapa_eventos_id`),
  CONSTRAINT `FK1qayvy3glc0bccx4opfhfnk0v` FOREIGN KEY (`etapa_eventos_id`) REFERENCES `etapa_evento` (`id`),
  CONSTRAINT `FKbxjllqvfl296ga8em82b363mt` FOREIGN KEY (`tarefas_id`) REFERENCES `tarefa` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tarefa_etapa_eventos`
--

LOCK TABLES `tarefa_etapa_eventos` WRITE;
/*!40000 ALTER TABLE `tarefa_etapa_eventos` DISABLE KEYS */;
INSERT INTO `tarefa_etapa_eventos` VALUES (1,1),(1,2),(1,3),(1,4),(1,5);
/*!40000 ALTER TABLE `tarefa_etapa_eventos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `turma`
--

DROP TABLE IF EXISTS `turma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `turma` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `professor_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9xwtpw9i63l1u1uevrsdc6g69` (`professor_id`),
  CONSTRAINT `FK9xwtpw9i63l1u1uevrsdc6g69` FOREIGN KEY (`professor_id`) REFERENCES `professor` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `turma`
--

LOCK TABLES `turma` WRITE;
/*!40000 ALTER TABLE `turma` DISABLE KEYS */;
INSERT INTO `turma` VALUES (1,'Tuma numero 01','Turma 1',1),(2,'Turma numero 2','Turma  2',1),(3,'Turma numero 3','Turma 3',1);
/*!40000 ALTER TABLE `turma` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `turma_alunos`
--

DROP TABLE IF EXISTS `turma_alunos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `turma_alunos` (
  `turmas_id` int(11) NOT NULL,
  `alunos_id` int(11) NOT NULL,
  PRIMARY KEY (`turmas_id`,`alunos_id`),
  KEY `FK3ae0fi80uylf7jbthfxbgbm3n` (`alunos_id`),
  CONSTRAINT `FK3ae0fi80uylf7jbthfxbgbm3n` FOREIGN KEY (`alunos_id`) REFERENCES `aluno` (`id`),
  CONSTRAINT `FKh1ig95q01iccxv2ywgejuhom6` FOREIGN KEY (`turmas_id`) REFERENCES `turma` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `turma_alunos`
--

LOCK TABLES `turma_alunos` WRITE;
/*!40000 ALTER TABLE `turma_alunos` DISABLE KEYS */;
INSERT INTO `turma_alunos` VALUES (1,1),(1,2),(1,4),(1,5),(1,6),(1,7);
/*!40000 ALTER TABLE `turma_alunos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(255) NOT NULL,
  `senha` varchar(255) DEFAULT NULL,
  `tipo_usuario` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_pm3f4m4fqv89oeeeac4tbe2f4` (`login`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'admin','$2a$10$GHxWnCkHFeRgtWROVbJAKuNwdKwYZBJxS/8RaYYdchh4pmGXQ8og2','ADMIN'),(2,'professor','$2a$10$6mLgJvpknvvvdXsN3FQwyOwgNKpKxHNwf9x0ZL.R.ob9x7c6sBr7u','PROFESSOR'),(3,'BETA','$2a$10$DYw4CFxDOYBQK0RGT9pa0uhFj9Fl4qMC7GmASwJs.SND/WRFhQMiK','GRUPO');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-01-09 20:29:09
