package br.du.fatec.zl.CrudJavaWebSpringData.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.du.fatec.zl.CrudJavaWebSpringData.model.Professor;
import br.du.fatec.zl.CrudJavaWebSpringData.service.IProfessorService;

@Controller
public class ProfessorController {

	@Autowired
	IProfessorService professorService;

	@RequestMapping(name = "professor", value = "/professor", method = RequestMethod.GET)
	public ModelAndView professorGet(ModelMap model) {
		return new ModelAndView("professor");
	}

	@RequestMapping(name = "professor", value = "/professor", method = RequestMethod.POST)
	public ModelAndView professorPost(@RequestParam Map<String, String> allRequestParam, ModelMap model) {
		// entrada
		String cmd = allRequestParam.get("botao");
		String codigo = allRequestParam.get("codigo");
		String nome = allRequestParam.get("nome");
		String disciplinaCodigo = allRequestParam.get("disciplinaCodigo");

		// retorno
		String saida = "";
		String erro = "";
		Professor p = new Professor();
		List<Professor> professores;

		if (!cmd.contains("Listar")) {
			p.setCodigo(Integer.parseInt(codigo));
		}
		if (cmd.contains("Cadastrar")) {
			p.setCodigo(Integer.parseInt(codigo));
			p.setNome(nome);
            p.setDisciplinaCodigo(Integer.parseInt(disciplinaCodigo));

			cadastrarProfessor(p);
			p = null;
		} else if (cmd.contains("Buscar")) {
			p = buscarProfessor(Integer.parseInt(codigo));
		}

		professores = listarProfessores();

		model.addAttribute("saida", saida);
		model.addAttribute("erro", erro);
		model.addAttribute("professor", p);
		model.addAttribute("professores", professores);

		return new ModelAndView("professor");
	}

	private void cadastrarProfessor(Professor professor) {
		professorService.saveProfessor(professor);
	}

	private Professor buscarProfessor(int codigo) {
		return professorService.getProfessorById(codigo);
	}

	private List<Professor> listarProfessores() {
		return professorService.getAllProfessores();
	}
}
