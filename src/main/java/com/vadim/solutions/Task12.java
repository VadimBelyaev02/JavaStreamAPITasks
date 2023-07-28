package com.vadim.solutions;

import com.vadim.model.Recruit;
import com.vadim.utils.RecruitListWrapper;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

public class Task12 {

    public static void main(String[] args) {
        List<Recruit> recruits = RecruitListWrapper.getRecruits(true);
        String gender = "Male";
        LocalDate from = LocalDate.now().minusYears(27);
        LocalDate to = LocalDate.now().minusYears(18);

        recruits.stream()
                .filter(r -> r.getDateOfBirth().isAfter(from) && r.getDateOfBirth().isBefore(to) && r.getGender().equals(gender))
                // it would be clearer to write the line above using two filters, but actually I think that
                // if someone has difficulties with understanding it because of a long line I think he should give up programming
                .sorted(Comparator.comparingInt(Recruit::getRecruitmentGroup))
                .limit(200)
                .forEach(System.out::println);
    }
}
/*
"id":1,"firstName":"Kerry","lastName":"Andreia","dateOfBirth":"1991-02-13",
"email":"kandreia0@comsenz.com","gender":"Male","recruitmentGroup":1,"city":"Tiantai Chengguanzhen",
"occupation":"Recruiting Manager"},

Задача №12 -
Во Французский легион принимают людей со всего света, но есть отбор по полу (только мужчины)
возраст от 18 до 27 лет. Преимущество отдаётся людям военной категории 1, на втором месте - военная категория 2,
и на третьем месте военная категория 3. Отсортировать всех подходящих кандидатов в порядке их
приоритета по военной категории. Однако взять на обучение академия может только 200 человек. Вывести их в консоль.
 */