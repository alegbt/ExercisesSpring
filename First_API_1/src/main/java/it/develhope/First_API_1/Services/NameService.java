package it.develhope.First_API_1.Services;

import org.springframework.stereotype.Service;

@Service
public class NameService {

    private String name;

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public String regName(){
        setName("alessandro");
        return name;
    }

    public StringBuilder revName(){
        return new StringBuilder("alessandro").reverse();
    }

}
