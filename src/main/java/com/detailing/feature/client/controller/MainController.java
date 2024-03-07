package com.detailing.feature.client.controller;

import com.detailing.feature.client.dto.CreateClientRequest;
import com.detailing.feature.client.dto.CreateClientResponse;
import com.detailing.feature.client.entity.Client;
import com.detailing.feature.client.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
//@RequestMapping("api/v1/")
public class MainController {
    private final ClientService clientService;

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
}
