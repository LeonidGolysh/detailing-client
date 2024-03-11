package com.detailing.feature.client.controller;

import com.detailing.feature.client.dto.create.CreateClientRequest;
import com.detailing.feature.client.dto.update.UpdateClientRequest;
import com.detailing.feature.client.entity.Client;
import com.detailing.feature.client.repository.ClientRepository;
import com.detailing.feature.client.service.ClientService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@Controller
@AllArgsConstructor
//@RequestMapping("api/v1/")
public class MainController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/")
    public String main() {
        return "main";
    }

    @GetMapping("/create")
    public String createClient(Model model) {
        model.addAttribute("clientEntity", new CreateClientRequest());
        return "createClient";
    }

    @PostMapping("/create")
    public String createClient(@ModelAttribute("clientEntity") CreateClientRequest request, Model model) {
        clientService.createClient(request);
        return "redirect:/client";
    }

    @GetMapping("/client")
    public String showClients(Model model) {
        model.addAttribute("clients", clientService.getAllClients());
        return "client";
    }

    @GetMapping("/edit")
    public String editClient() {
        return "updateClient";
    }

    @GetMapping("/client/delete")
    public String showDeleteClientFrom(@RequestParam("id") UUID clientId, Model model) {
        model.addAttribute("clientId", clientId);
        return "deleteClient";
    }

    @PostMapping("/client/delete")
    public String deleteClient(@RequestParam("id") UUID clientId) {
        clientService.deleteClient(clientId);
        return "redirect:/client";
    }
}
