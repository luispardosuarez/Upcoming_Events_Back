package veroslaves.upcoming_events_back.events;

import java.util.List;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import veroslaves.upcoming_events_back.interfaces.IGenericFullService;

@RestController
@RequestMapping(path = "${api-endpoint}/events")
public class EventController {
    
    IGenericFullService <Event> service;

    

    public EventController(IGenericFullService<Event> service) {
        this.service = service;
    }

    @GetMapping(path = "")
    public List<Event> index() {

        List<Event> events = service.getAll();
        return events;

    }

    @GetMapping(path = "/getById/{id}")
    public ResponseEntity<Event> getOneById(@PathVariable("id") Long id) throws Exception {

        Event event = service.getById(id);

        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(event);
    }
    
}
