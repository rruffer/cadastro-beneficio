package br.com.rruffer.cadastro.beneficio.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rruffer.cadastro.beneficio.dto.ClienteDTO;
import br.com.rruffer.cadastro.beneficio.producer.ClienteProducer;

@RestController
@RequestMapping("/cadastro")
public class CadastroResource {

	@Autowired
	private ClienteProducer clienteProducer;
	
	/*@GetMapping("/{mensagem}")
	public ResponseEntity<String> cadastro(@PathVariable("mensagem") String mensagem) {

		jmsTemplate.convertAndSend(queue, mensagem);
		
		return ResponseEntity.ok().build();
	}*/
	
	@PostMapping
	public ResponseEntity<Void> atualizarUsuario(@RequestBody ClienteDTO clienteDTO) {
		clienteProducer.send(clienteDTO);
		return ResponseEntity.ok().build();
	}
	
}
