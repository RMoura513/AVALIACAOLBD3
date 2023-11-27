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

import br.du.fatec.zl.CrudJavaWebSpringData.model.Horario;
import br.du.fatec.zl.CrudJavaWebSpringData.service.IHorarioService;

@Controller
public class HorarioController {

	@Autowired
	IHorarioService horarioService;

	@RequestMapping(name = "horario", value = "/horario", method = RequestMethod.GET)
	public ModelAndView horarioGet(ModelMap model) {
		return new ModelAndView("horario");
	}

	@RequestMapping(name = "horario", value = "/horario", method = RequestMethod.POST)
	public ModelAndView horarioPost(@RequestParam Map<String, String> allRequestParam, ModelMap model) {

		// entrada
		String cmd = allRequestParam.get("botao");

		// retorno
		String saida = "";
		String erro = "";
		Horario ho = new Horario();
		List<Horario> horarios = new ArrayList<>();

		try {
			if (cmd.contains("Listar")) {
				horarios = listarHorario();
			}

		} catch (SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		} finally {
			model.addAttribute("saida", saida);
			model.addAttribute("erro", erro);
			model.addAttribute("horario", ho);
			model.addAttribute("horarios", horarios);

		}

		return new ModelAndView("horario");
	}

	private List<Horario> listarHorario() throws SQLException, ClassNotFoundException {
		return horarioService.getAllHorarios();
	}
}
