package com.vadim.solutions;

import com.vadim.model.Performer;
import com.vadim.model.Song;
import com.vadim.model.enums.Genre;
import com.vadim.utils.PerformerListWrapper;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task15 {

    public static void main(String[] args) {
        List<Genre> genres = Stream.of(Genre.METAL, Genre.POP, Genre.ROCK).toList();
        List<Performer> performers = PerformerListWrapper.getPerformers(true);

        Predicate<Performer> datePredicate = performer -> performer.getSongs().stream()
                .noneMatch(song -> song.getReleaseDate().isBefore(LocalDate.of(2010, Month.JANUARY, 1)));


        Predicate<Performer> genrePredicate = performer -> genres.stream().anyMatch(g -> g.equals(performer.getGenre()));


        Map<Genre, List<Performer>> result = performers.stream()
                .sorted(Comparator.comparing(p -> p.getSongs()
                        .stream()
                        //.mapToInt(Song::getLikesCount).sum())) I can get expected answer with this line
                        // but actually the correct one is with the line above (otherwise I'll get the bottom of the top)
                        // so yeah I rechecked a lot of times, the correct answer is empty according to the task description and given data
                        .mapToInt(Song::getLikesCount).sum(), Comparator.reverseOrder()))
                .limit(6)
                .filter(datePredicate.and(genrePredicate))
                .sorted(Comparator.comparing(Performer::getName))
                .collect(Collectors.groupingBy(Performer::getGenre));

        System.out.println(result);
    }
}
/*
Задача №15 -
IT-компания выпускает музыкальный стриминговый сервис ScamMusic. Компания молодая, поэтому арендуемые ею сервера
не самые мощные и требуется тщательно отфильтровать музыкальных исполнителей для выпуска MVP данного сервиса.

Для начала из предложенных исполнителей нужно отобрать 6 самых популярных (по лайкам) и выбрать тех, чьи песни были
выпущены не ранее 2010 года и имеют жанр (ROCK, POP или METAL). Далее требуется отсортировать исполнителей по имени в
алфавитном порядке и вывести сгрупированных по жанру исполнителей в консоль.
 */