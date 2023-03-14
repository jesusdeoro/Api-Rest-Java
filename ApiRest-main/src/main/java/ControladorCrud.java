package com.inezpre5.controlador;
 
import javax.validation.Valid;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
 
import com.inezpre5.modelo.Actor;
import com.inezpre5.modelo.ActorCrud;
 
@Controller
@RequestMapping("/crud")
public class ControladorCrud {
 
    @Autowired
    private ActorCrud ac;
 
    @RequestMapping(value="", method = RequestMethod.GET)
    public String listaActores(ModelMap mp){
        mp.put("actores", uc.findAll());
        return "crud/lista";
    }
 
    @RequestMapping(value="/nuevo", method=RequestMethod.GET)
    public String nuevo(ModelMap mp){
        mp.put("actor", new Actor());
        return "crud/nuevo";
    }
 
    @RequestMapping(value="/crear", method=RequestMethod.POST)
    public String crear(@Valid Actor actor,
            BindingResult bindingResult, ModelMap mp){
        if(bindingResult.hasErrors()){
            return "/crud/nuevo";
        }else{
            ac.save(actor);
            mp.put("actor", actor);
            return "crud/creado";
        }
    }
 
    @RequestMapping(value="/creado", method = RequestMethod.POST)
    public String creado(@RequestParam("actor") Actor actor){
        return "/crud/creado";
    }
 
}
    @RequestMapping(value="/borrar/{id}", method=RequestMethod.GET)
    public String borrar(@PathVariable("id") long id, ModelMap mp){
        ac.delete(ac.findOne(id));
        mp.put("actores", ac.findAll());
        return "crud/lista";
}
    

    @RequestMapping(value="/editar/{id}", method=RequestMethod.GET)
    public String editar(@PathVariable("id") long id, ModelMap mp){
        mp.put("actor", ac.findOne(id));
        return "crud/editar";
    }
    
    @RequestMapping(value="/actualizar", method=RequestMethod.POST)
    public String actualizar(@Valid Actor actor, BindingResult bindingResult, ModelMap mp){
        if(bindingResult.hasErrors()){
            mp.put("actor", ac.findAll());
        return "crud/lista";
        }
        Actor actor = ac.findOne(actor.getId());
        actor.setFirst_name(actor.getFirst_name());
        actor.setLast_name(actor.getLast_name());
        actor.setLast_update(actor.getLast_update());
        ac.save(actor);
        mp.put("actor", actor);
        return "crud/actualizado";


}
