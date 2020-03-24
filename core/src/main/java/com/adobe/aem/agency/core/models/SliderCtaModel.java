package com.adobe.aem.agency.core.models;

import com.adobe.aem.agency.core.entities.Slide;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.ArrayList;

@Model(adaptables = Resource.class)
public class SliderCtaModel {

    @Inject
    @Optional
    protected Resource slides;

    private ArrayList<Slide> items = new ArrayList<>();

    @PostConstruct
    protected void init() {
        if (slides != null && slides.hasChildren()) {
            for (Resource item : slides.getChildren()) {
                ValueMap vm = item.getValueMap();
                Slide slide = new Slide();
                slide.setTitle(vm.containsKey("title") ? vm.get("title", String.class) : null);
                slide.setContent(vm.containsKey("content") ? vm.get("content", String.class) : null);

                slide.setBackground(vm.containsKey("imageRef") ? vm.get("imageRef", String.class) : null);


                slide.setShowButton(vm.containsKey("buttonShow") ? vm.get("buttonShow", Boolean.class) : true);
                slide.setButtonText(vm.containsKey("buttonText") ? vm.get("buttonText", String.class) : null);
                slide.setButtonLink(vm.containsKey("buttonLink") ? vm.get("buttonLink", String.class) : null);
                items.add(slide);
            }
        }
    }

    public ArrayList<Slide> getItems() {
        return items;
    }
}
