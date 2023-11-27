package br.du.fatec.zl.CrudJavaWebSpringData.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.du.fatec.zl.CrudJavaWebSpringData.model.Curso;
import br.du.fatec.zl.CrudJavaWebSpringData.service.ICursoService;

@Controller
public class CursoController {

	@Autowired
	ICursoService cursoService;

	@RequestMapping(name = "curso", value = "/curso", method = RequestMethod.GET)
	public ModelAndView cursoGet(ModelMap model) {
		return new ModelAndView("curso");
	}

	@RequestMapping(name = "curso", value = "/curso", method = RequestMethod.POST)
	public ModelAndView cursoPost(@RequestParam Map<String, String> allRequestParam, ModelMap model) {

		// entrada
		String cmd = allRequestParam.get("botao");

		// retorno
		String saida = "";
		String erro = "";
		Curso cr = new Curso();
		List<Curso> cursos = new ArrayList<>();

		try {
			if (cmd.contains("Listar")) {
				cursos = listarCurso();
			}

		} catch (SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		} finally {
			model.addAttribute("saida", saida);
			model.addAttribute("erro", erro);
			model.addAttribute("curso", cr);
			model.addAttribute("cursos", cursos);

		}

		return new ModelAndView("curso");
	}

	private List<Curso> listarCurso() throws SQLException, ClassNotFoundException {
		return cursoService.getAllCursos();
	}
}
