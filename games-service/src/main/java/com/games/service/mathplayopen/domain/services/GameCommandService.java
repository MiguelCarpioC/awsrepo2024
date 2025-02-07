package com.games.service.mathplayopen.domain.services;

import com.games.service.mathplayopen.domain.model.commands.FavoriteGameCommand;
import com.games.service.mathplayopen.domain.model.entities.FavoriteGame;
import com.games.service.mathplayopen.domain.model.aggregates.Game;
import com.games.service.mathplayopen.domain.model.entities.GameScore;

import java.util.List;

public interface GameCommandService {
    List<Game> fetchAndSaveExternalGames();
    FavoriteGame markGameAsFavorite(FavoriteGameCommand command);
    void removeGameFromFavorites(Long gameId, Long studentId);


    void updateStudentScore(Long studentId, int score);
    GameScore getStudentScore(Long studentId);
}
