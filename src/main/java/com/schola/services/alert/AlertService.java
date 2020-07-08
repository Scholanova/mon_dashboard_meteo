package com.schola.services.alert;

import com.schola.entity.alert.Alert;
import com.schola.repository.alert.AlertRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertService {
    private AlertRepository alertRepository;

    public AlertService(AlertRepository alertRepository) {
        this.alertRepository = alertRepository;
    }

    public List<Alert> listAll() {
        return alertRepository.findAll();
    }


    public Alert getAlertById(Integer id) {
        return alertRepository.findById(id).get();
    }


    public Alert saveAlert(Alert alert) {
        return alertRepository.save(alert);
    }

    public void deleteAlert(Integer id) {
        alertRepository.deleteById(id);
    }
}
