package br.com.rruffer.cadastro.beneficio.producer;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import br.com.rruffer.cadastro.beneficio.dto.ClienteDTO;
import br.com.rruffer.cadastro.beneficio.util.JsonUtil;

@Component
public class ClienteProducer {

	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Autowired
	private Queue queue;
	
	public void send(ClienteDTO clienteDTO) {
		String cliente = JsonUtil.serializarJSON(clienteDTO, true);
		jmsTemplate.convertAndSend(queue, cliente);
	}
	
}
