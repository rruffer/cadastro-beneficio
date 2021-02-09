package br.com.rruffer.cadastro.beneficio.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rruffer.cadastro.beneficio.dto.ClienteDTO;
import br.com.rruffer.cadastro.beneficio.entity.Cliente;
import br.com.rruffer.cadastro.beneficio.producer.ClienteProducer;
import br.com.rruffer.cadastro.beneficio.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ClienteProducer clienteProducer;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;

	@Autowired
	private ModelMapper mapper;
	
	public Cliente salvar(ClienteDTO clienteDTO) throws Exception {
		
		Cliente cliente = mapper.map(clienteDTO, Cliente.class);
		cliente.setId(sequenceGeneratorService.generateSequence(Cliente.SEQUENCE_NAME));
		clienteRepository.save(cliente);
		
		clienteDTO.setId(cliente.getId());
		clienteProducer.send(clienteDTO);
		
		return cliente;
	}
	
	public void salvar(Cliente cliente) throws Exception{
		cliente.setId(sequenceGeneratorService.generateSequence(Cliente.SEQUENCE_NAME));
		clienteRepository.save(cliente);
		ClienteDTO clienteDTO = mapper.map(cliente, ClienteDTO.class);
		clienteProducer.send(clienteDTO);
	}
	
}
