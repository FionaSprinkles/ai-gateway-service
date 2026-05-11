package com.github.fionasprinkles.aigatewayservice;

import com.github.fionasprinkles.aigatewayservice.dto.MessageDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Service;

@Service
public class SessionMemoryService {

  private final Map<String, List<MessageDTO>> memory = new ConcurrentHashMap<>();

  public List<MessageDTO> getMessages(String sessionId) {
    return memory.getOrDefault(sessionId, new ArrayList<>());
  }

  public void addMessage(String sessionId, MessageDTO message) {

    memory.computeIfAbsent(sessionId, id -> new ArrayList<>()).add(message);
  }
}
