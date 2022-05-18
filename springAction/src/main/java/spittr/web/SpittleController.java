package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import spittr.data.Spittle;
import spittr.data.SpittleRepository;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/spittles")
public class SpittleController {
    private SpittleRepository repository;

    @Autowired
    public SpittleController(SpittleRepository repository){
        this.repository = repository;
    }

//    @RequestMapping(method = RequestMethod.GET)
//    public String spittles(Model model){
//        model.addAttribute(repository.findSpittes(Long.MAX_VALUE, 20));
//        return "spittles";
//    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Spittle> spittleList(){
        return repository.findSpittes(Long.MAX_VALUE, 20);
    }

    private final static String MAX_LONG_AS_STRING = Long.MAX_VALUE+"";

    //传递参数，带默认值
    @RequestMapping(value = "/param",method = RequestMethod.GET)
    public String spittles(@RequestParam(value="max", defaultValue = MAX_LONG_AS_STRING) long max,
                                  @RequestParam(value = "count", defaultValue = "20") int count,
                                  Map model){
        model.put("spittleList", repository.findSpittes(max, count));
        return "spittles";
    }

    //传递参数
    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String showSpittles(@RequestParam(value="spttle_id") long spittleId,
                                  Model model){
        model.addAttribute(repository.findOne(spittleId));
        return "spittle";
    }

    //直接在地址上传入参数
    @RequestMapping(value = "/{spttleId}", method = RequestMethod.GET)
    public String spittle(@PathVariable("spttleId") long spittleId,
                               Model model){
        model.addAttribute(repository.findOne(spittleId));
        return "spittle";
    }

}
