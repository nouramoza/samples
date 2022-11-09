create table account
(
    id             bigint not null,
    account_number VARCHAR2(20 char)
        constraint ACCOUNT_NUMBER_UK
        unique,
    person_id      NUMBER(38),
    balance        NUMBER(38, 6),
    is_active      NUMBER(1) default 0,
    primary key (id)
);

--data insertion
INSERT INTO public.account(id, account_number, balance, is_active, person_id)
VALUES (1, 8776672, 1000, true, 1);

INSERT INTO public.account(id, account_number, balance, is_active, person_id)
VALUES (2, 36435552, 0, true, 2);

INSERT INTO public.account(id, account_number, balance, is_active, person_id)
VALUES (3, 754632562, 500, true, 3);

INSERT INTO public.account(id, account_number, balance, is_active, person_id)
VALUES (4, 3473265, 220, true, 4);



create table card
(
    id                  bigint not null,
    card_number         VARCHAR2(20 char)
        constraint CARD_NUMBER_UK
        unique,
    cvv2                NUMBER(6),
    expire_date         DATE,
    is_active           NUMBER(1) default 0,
    pin                 NUMBER(4),
    account_id          NUMBER(38),
    incorrect_pin_count NUMBER(2),
    primary key (id)
);

-- CARD DATA INSERTION
INSERT INTO public.card(id, card_number, cvv2, expire_date, is_active, pin, account_id, incorrect_pin_count)
VALUES (1, 6280231451904303, 199, TO_DATE('11/11/2022', 'DD/MM/YYYY'), true, 1233, 1, 0);

INSERT INTO public.card(id, card_number, cvv2, expire_date, is_active, pin, account_id, incorrect_pin_count)
VALUES (2, 628023145234765, 342, TO_DATE('11/11/2022', 'DD/MM/YYYY'), false, 1111, 2, 0);

INSERT INTO public.card(id, card_number, cvv2, expire_date, is_active, pin, account_id, incorrect_pin_count)
VALUES (3, 628023145412347, 202, TO_DATE('11/11/2020', 'DD/MM/YYYY'), true, 7654, 1, 0);

INSERT INTO public.card(id, card_number, cvv2, expire_date, is_active, pin, account_id, incorrect_pin_count)
VALUES (4, 6280231476123412, 239, TO_DATE('11/11/2022', 'DD/MM/YYYY'), true, 1233, 1, 0);
