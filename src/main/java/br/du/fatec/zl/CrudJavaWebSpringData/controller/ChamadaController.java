package br.du.fatec.zl.CrudJavaWebSpringData.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.du.fatec.zl.CrudJavaWebSpringData.model.Chamada;
import br.du.fatec.zl.CrudJavaWebSpringData.service.IChamadaService;

@Controller
public class ChamadaController {

	@Autowired
	private IChamadaService chamadaService;

	@RequestMapping(name = "chamada", value = "/chamada", method = RequestMethod.GET)
	public ModelAndView chamadaGet(ModelMap model) {
		return new ModelAndView("chamada");
	}

	@RequestMapping(name = "chamada", value = "/chamada", method = RequestMethod.POST)
	public ModelAndView chamadaPost(@RequestParam Map<String, String> allRequestParam, ModelMap model) {
		String cmd = allRequestParam.get("botao");
		int disciplinaCodigo = Integer.parseInt(allRequestParam.get("disciplinaCodigo"));

		if (cmd.contains("Iniciar")) {
			try {
				List<Chamada> chamadas = chamadaService.getChamadasByDisciplinaCodigo(disciplinaCodigo);
				model.addAttribute("chamadas", chamadas);
			} catch (Exception e) {
				model.addAttribute("erro", "Erro ao obter dados do banco de dados.");
				e.printStackTrace();
			}
		}

		return new ModelAndView("chamada", model);
	}

	@RequestMapping(value = "/processaChamada", method = RequestMethod.POST)
	public ModelAndView processaChamada(@RequestParam Map<String, String> allRequestParam,
			@RequestParam("ausencia") int[] ausencias, @RequestParam("alunoRA") int[] alunoRAs,
			@RequestParam("disciplinaCodigo") int disciplinaCodigo, @RequestParam("dataChamada") LocalDate dataChamada,
			ModelMap model) {
		String cmd = allRequestParam.get("botao");
		if (cmd.contains("Enviar")) {
			try {
				chamadaService.processarChamada(ausencias, alunoRAs, disciplinaCodigo, dataChamada);
				model.addAttribute("mensagem", "Dados processados com sucesso!");
			} catch (Exception e) {
				model.addAttribute("erro", "Erro ao processar os dados: " + e.getMessage());
			}
		}
		if (cmd.contains("Alterar")) {
			try {
				chamadaService.processarChamada(ausencias, alunoRAs, disciplinaCodigo, dataChamada);
				model.addAttribute("mensagem", "Dados processados com sucesso!");
			} catch (Exception e) {
				model.addAttribute("erro", "Erro ao processar os dados: " + e.getMessage());
			}
		}
		try {
			List<Chamada> chamadas = chamadaService.consultarChamada(disciplinaCodigo);
			model.addAttribute("chamadas", chamadas);
		} catch (Exception e) {
			model.addAttribute("erro", "Erro ao obter dados do banco de dados.");
			e.printStackTrace();
		}
		return new ModelAndView("chamada", model);
	}

}