package com.nn.controller;

import com.marvin.component.container.awareness.ContainerAware;

public class DefaultController extends ContainerAware {

//    @Route(name = "default.home", path = "/")//, reponse="ressources/view/nav.view.twig"
    public void charger() {
        System.out.println("default.charger");
    }
}
