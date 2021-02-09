package br.com.rruffer.cadastro.beneficio.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rruffer.cadastro.beneficio.dto.ClienteDTO;
import br.com.rruffer.cadastro.beneficio.services.ClienteService;

@CrossOrigin
@RestController
@RequestMapping("/cadastro")
public class CadastroResource {

	@Autowired
	private ClienteService clienteService;
	
	
	@GetMapping
	public ResponseEntity<String> cadastro() {
		return ResponseEntity.ok().build();
	}
	
	@PostMapping
	public ResponseEntity<Void> atualizarUsuario(@RequestBody ClienteDTO clienteDTO) {
		
		try {
			clienteService.salvar(clienteDTO);
		} catch (Exception e) {
			e.printStackTrace();
			ResponseEntity.status(440).build();
		}
		
		return ResponseEntity.ok().build();
	}
	
}
