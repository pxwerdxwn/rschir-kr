-- Создание таблицы Departments (Отделы)
CREATE SCHEMA bugtracker;
CREATE TABLE status
(
    status_id INT AUTO_INCREMENT PRIMARY KEY,
    status_name VARCHAR(30) NOT NULL
);
CREATE TABLE team_members
(
    member_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(60) NOT NULL,
    last_name VARCHAR(60) NOT NULL,
    email_address VARCHAR(250) NOT NULL
);
CREATE TABLE type
(
    type_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30) NOT NULL
);
CREATE TABLE project
(
    project_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(60) NOT NULL,
    description VARCHAR(250),
    status_id INT DEFAULT 1,
    member_id INT,
    FOREIGN KEY(status_id) REFERENCES status(status_id),
    FOREIGN KEY (member_id) REFERENCES team_members(member_id)
);
USE bugtracker;
CREATE TABLE item
(
    item_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(60) NOT NULL,
    description VARCHAR(250),
    status_id INT,
    FOREIGN KEY(status_id) REFERENCES status(status_id),
    type_id INT,
    member_id INT,
    FOREIGN KEY(type_id) REFERENCES type(type_id),
    FOREIGN KEY (member_id) REFERENCES team_members(member_id)
);

CREATE TABLE Departments (
                             department_id INT PRIMARY KEY AUTO_INCREMENT,
                             name VARCHAR(50) NOT NULL,
                             manager_id INT,
                             FOREIGN KEY (manager_id) REFERENCES team_members(member_id)
);

-- Создание таблицы Tasks (Задачи)
CREATE TABLE Tasks (
                       task_id INT PRIMARY KEY AUTO_INCREMENT,
                       name VARCHAR(100) NOT NULL,
                       description VARCHAR(255),
                       status_id INT,
                       project_id INT,
                       assignee_id INT,
                       deadline DATE,
                       FOREIGN KEY (status_id) REFERENCES status(status_id),
                       FOREIGN KEY (project_id) REFERENCES project(project_id),
                       FOREIGN KEY (assignee_id) REFERENCES team_members(member_id)
);

-- Создание таблицы Clients (Клиенты)
CREATE TABLE Clients (
                         client_id INT PRIMARY KEY AUTO_INCREMENT,
                         name VARCHAR(100) NOT NULL,
                         contact_email VARCHAR(100) NOT NULL,
                         phone_number VARCHAR(15),
                         project_id INT,
                         FOREIGN KEY (project_id) REFERENCES Project(project_id)
);


-- Создание таблицы Documents (Документы)
CREATE TABLE Documents (
                           document_id INT PRIMARY KEY AUTO_INCREMENT,
                           project_id INT NOT NULL,
                           name VARCHAR(100) NOT NULL,
                           file_url VARCHAR(255) NOT NULL,
                           uploaded_by INT,
                           FOREIGN KEY (project_id) REFERENCES project(project_id),
                           FOREIGN KEY (uploaded_by) REFERENCES team_members(member_id)
);

-- Заполнение таблицы Departments

INSERT INTO bugtracker.team_members VALUES (1, 'Джон', 'Томпсон', 'j.thompson@spring.com');
INSERT INTO bugtracker.team_members VALUES (2, 'Мэри', 'Джонсон', 'm.johnson@spring.com');
INSERT INTO bugtracker.team_members VALUES (3, 'Джуди', 'Гордон', 'j.gordon@spring.com');
INSERT INTO bugtracker.team_members VALUES (4, 'Фрэнк', 'Уильямс', 'f.williams@spring.com');

INSERT INTO bugtracker.status VALUES (1, 'К выполнению');
INSERT INTO bugtracker.status VALUES (2, 'В процессе');
INSERT INTO bugtracker.status VALUES (3, 'На проверке');
INSERT INTO bugtracker.status VALUES (4, 'Готово');

INSERT INTO bugtracker.type VALUES (1, 'Задача');
INSERT INTO bugtracker.type VALUES (2, 'Исследование');
INSERT INTO bugtracker.type VALUES (3, 'Поддержка');
INSERT INTO bugtracker.type VALUES (4, 'Ошибка');

INSERT INTO bugtracker.project VALUES (1, 'Проект Метро', 'Увеличить производительность', 1, 1);
INSERT INTO bugtracker.project VALUES (2, 'Проект Слоновая кость', 'Сократить время и стоимость проекта', 3, 2);
INSERT INTO bugtracker.project VALUES (3, 'Проект Аполлон', 'Улучшить взаимодействие между командами', 4, 3);
INSERT INTO bugtracker.project VALUES (4, 'Проект Кодиак', 'Найти инновационные решения и подходы', 3, 4);

INSERT INTO bugtracker.item VALUES (1, 'Реализация Проекта Аполлон', 'Реализация результатов Проекта Аполлон', 1, 1, 1);
INSERT INTO bugtracker.item VALUES (2, 'Проект Аполлон: PIR', 'Провести PIR Проекта Аполлон', 2, 2, 2);
INSERT INTO bugtracker.item VALUES (3, 'Определить задачи для Проекта Метро', 'Определить план проекта и дорожную карту', 4, 2, 3);
INSERT INTO bugtracker.item VALUES (4, 'Исправить ошибку на сайте', 'Протестировать сайт в разных браузерах', 3, 4, 4);

INSERT INTO bugtracker.Departments VALUES (1, 'Разработка', 1);
INSERT INTO bugtracker.Departments VALUES (2, 'Маркетинг', 2);
INSERT INTO bugtracker.Departments VALUES (3, 'Продажи', 3);
INSERT INTO bugtracker.Departments VALUES (4, 'Кадры', 4);

INSERT INTO bugtracker.Tasks VALUES (1, 'Дизайн сайта', 'Создание макетов для нового сайта', 1, 1, 1, '2024-12-15');
INSERT INTO bugtracker.Tasks VALUES (2, 'Написание контента', 'Подготовка маркетингового контента', 2, 2, 2, '2024-12-20');
INSERT INTO bugtracker.Tasks VALUES (3, 'Разработка API', 'Создание API для мобильного приложения', 1, 1, 3, '2024-12-25');
INSERT INTO bugtracker.Tasks VALUES (4, 'Тестирование функций', 'Регрессионное тестирование перед релизом', 3, 1, 4, '2024-12-30');

INSERT INTO bugtracker.Clients VALUES (1, 'ТехКорп', 'info@techcorp.ru', '+71234567890', 1);
INSERT INTO bugtracker.Clients VALUES (2, 'РитейлИнк', 'contact@retailinc.ru', '+79876543210', 2);
INSERT INTO bugtracker.Clients VALUES (3, 'ФинРешения', 'support@financesol.ru', '+71122334455', 3);
INSERT INTO bugtracker.Clients VALUES (4, 'ЗдравСервис', 'info@healthcare.ru', '+75566778899', 4);

INSERT INTO Documents VALUES
                          (1, 1, 'План проекта', 'http://example.com/documents/plan_proekta.pdf', 1),
                          (2, 2, 'Маркетинговая стратегия', 'http://example.com/documents/marketing_strategy.pdf', 2),
                          (3, 3, 'Документация API', 'http://example.com/documents/api_documentation.pdf', 3),
                          (4, 1, 'Отчет по тестам', 'http://example.com/documents/test_report.pdf', 4);
