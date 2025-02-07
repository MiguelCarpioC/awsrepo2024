package com.games.service.mathplayopen.application.internal.commandservices;

import com.games.service.mathplayopen.domain.model.entities.GameScore;
import com.games.service.mathplayopen.domain.services.GameScoreService;
import com.games.service.mathplayopen.infrastructure.persistance.jpa.repositories.GameScoreRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class GameScoreServiceImpl implements GameScoreService {
    private final GameScoreRepository gameScoreRepository;

    public GameScoreServiceImpl(GameScoreRepository gameScoreRepository) {
        this.gameScoreRepository = gameScoreRepository;
    }

    @Transactional
    @Override
    public GameScore getScoreByStudentId(Long studentId) {
        return gameScoreRepository.findByStudentId(studentId)
                .orElseGet(() -> gameScoreRepository.save(new GameScore(studentId)));
    }

    @Transactional
    @Override
    public void updateScore(Long studentId, int newScore) {
        GameScore gameScore = getScoreByStudentId(studentId);
        gameScore.setScore(newScore);
        gameScoreRepository.save(gameScore);
    }
}
