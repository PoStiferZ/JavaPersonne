package com.example.personne.Factory;

import com.example.personne.Interface.PersonneAbstractFactory;
import com.example.personne.Model.Personne;

public class PersonneFactory {

    public static Personne getPersonne(PersonneAbstractFactory factory) {
        return factory.createPersonne();
    }
}
