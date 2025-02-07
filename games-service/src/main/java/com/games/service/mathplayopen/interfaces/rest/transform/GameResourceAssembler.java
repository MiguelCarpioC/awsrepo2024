package com.games.service.mathplayopen.interfaces.rest.transform;

import com.games.service.mathplayopen.domain.model.aggregates.Game;
import com.games.service.mathplayopen.domain.model.valueobjects.Description;
import com.games.service.mathplayopen.domain.model.valueobjects.EmbedCode;
import com.games.service.mathplayopen.domain.model.valueobjects.Title;
import com.games.service.mathplayopen.interfaces.rest.resources.GameResource;
import org.springframework.stereotype.Component;

@Component
public class GameResourceAssembler {
    public Game toEntity(GameResource resource) {
        return new Game(
                new Title(resource.title()),
                new Description(resource.description()),
                new EmbedCode(resource.embedCode()),
                resource.image(),
                resource.rules(),
                resource.topic()
        );
    }

    public GameResource toResource(Game game) {
        return new GameResource(
                game.getId(),
                game.getTitle().title(),
                game.getDescription().description(),
                game.getEmbedCode().code(),
                game.getImage(),
                game.getRules(),
                game.getTopic()
        );
    }
}
