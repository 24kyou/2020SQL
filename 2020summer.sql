/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2020/7/3 19:06:31                            */
/*==============================================================*/


drop table if exists coupons;

drop table if exists employee_inform;

drop table if exists full_discount;

drop table if exists merchandise_orders;

drop table if exists order_process_form;

drop table if exists product_recommendations;

drop table if exists product_evaluation;

drop table if exists product_infrom;

drop table if exists recipe_evaluation;

drop table if exists recipe_information;

drop table if exists time_limited_promotional;

drop table if exists addition;

drop table if exists cook;

drop table if exists dishes;

drop table if exists fedback;

drop table if exists send;

drop table if exists user;

drop table if exists user_sendplace;

/*==============================================================*/
/* Table: coupons                                               */
/*==============================================================*/
create table coupons
(
   coupons_id           varchar(25) not null,
   mer_order_id         varchar(255),
   content              varchar(255) not null,
   least_amount         float(6) not null,
   relief_money         float(6) not null,
   begin_date           datetime not null,
   end_date             datetime not null,
   primary key (coupons_id)
);

/*==============================================================*/
/* Table: employee_inform                                       */
/*==============================================================*/
create table employee_inform
(
   employee_id          varchar(25) not null,
   employee_name        varchar(255) not null,
   employee_pwd         varchar(255) not null,
   employee_po          int not null,
   employee_tel         varchar(255) not null,
   manager_id           varchar(25) not null,
   primary key (employee_id)
);

/*==============================================================*/
/* Table: full_discount                                         */
/*==============================================================*/
create table full_discount
(
   discount_id          varchar(25) not null,
   product_id           varchar(25),
   content              varchar(255) not null,
   discount             float(6) not null,
   product_number       int not null,
   begin_time           datetime not null,
   end_time             datetime not null,
   primary key (discount_id)
);

/*==============================================================*/
/* Table: merchandise_orders                                    */
/*==============================================================*/
create table merchandise_orders
(
   order_id             varchar(255) not null,
   coupons_id           varchar(25),
   user_id              varchar(25) not null,
   conctacter           varchar(255) not null,
   conctacter_tel       varchar(255) not null,
   s_employee_id        varchar(25) not null,
   buy_id               varchar(255) not null,
   o_amount             float(6) not null,
   r_amount             float(6) not null,
   primary key (order_id)
);

/*==============================================================*/
/* Table: order_process_form                                    */
/*==============================================================*/
create table order_process_form
(
   order_id             varchar(25) not null,
   user_id              varchar(25) not null,
   user_process_choice  varchar(255) not null,
   refund_amount        double not null,
   information          varchar(255) not null,
   primary key (order_id)
);

/*==============================================================*/
/* Table: product_recommendations                               */
/*==============================================================*/
create table product_recommendations
(
   product_id           varchar(25) not null,
   product_name         varchar(25) not null,
   category             varchar(25) not null,
   product_num          int not null,
   product_values       int not null,
   information          varchar(255) not null,
   product_price        real,
   primary key (product_id)
);

/*==============================================================*/
/* Table: product_evaluation                                    */
/*==============================================================*/
create table product_evaluation
(
   user_id              varchar(25) not null,
   product_id           varchar(25) not null,
   record_date          datetime not null,
   record               varchar(255) not null,
   record_values        int not null,
   primary key (user_id, product_id)
);

/*==============================================================*/
/* Table: product_infrom                                        */
/*==============================================================*/
create table product_infrom
(
   product_id           varchar(25) not null,
   discount_id          varchar(25),
   pro_id               varchar(25),
   category             varchar(25) not null,
   product_name         varchar(25) not null,
   product_num          int not null,
   product_price        float(6) not null,
   product_vip_price    float(6) not null,
   information          varchar(255) not null,
   primary key (product_id)
);

/*==============================================================*/
/* Table: recipe_evaluation                                     */
/*==============================================================*/
create table recipe_evaluation
(
   user_id              varchar(25) not null,
   recipe_id            varchar(25) not null,
   record               varchar(25) not null,
   is_well              int,
   record_date          datetime,
   primary key (user_id, recipe_id)
);

/*==============================================================*/
/* Table: recipe_information                                    */
/*==============================================================*/
create table recipe_information
(
   recipe_id            varchar(25) not null,
   recipe_name          varchar(25) not null,
   categoty_price       float(6) not null,
   categoty_last        int not null,
   recommend_values     int not null,
   categories           varchar(255) not null,
   primary key (recipe_id)
);

/*==============================================================*/
/* Table: time_limited_promotional                              */
/*==============================================================*/
create table time_limited_promotional
(
   pro_id               varchar(25) not null,
   product_id           varchar(25),
   pro_amount           float(6) not null,
   pro_num              int not null,
   begin_time           datetime not null,
   end_time             datetime not null,
   primary key (pro_id)
);

/*==============================================================*/
/* Table: addition                                              */
/*==============================================================*/
create table addition
(
   employee_id          varchar(25) not null,
   product_id           varchar(25) not null,
   primary key (employee_id, product_id)
);

/*==============================================================*/
/* Table: cook                                                  */
/*==============================================================*/
create table cook
(
   order_id             varchar(255) not null,
   employee_id          varchar(25) not null,
   primary key (order_id, employee_id)
);

/*==============================================================*/
/* Table: dishes                                                */
/*==============================================================*/
create table dishes
(
   order_id             varchar(255) not null,
   recipe_id            varchar(255) not null,
   cook_time            time,
   deadline             datetime,
   primary key (order_id)
);

/*==============================================================*/
/* Table: fedback                                               */
/*==============================================================*/
create table fedback
(
   employee_id          varchar(25) not null,
   order_id             varchar(25) not null,
   primary key (order_id)
);

/*==============================================================*/
/* Table: send                                                  */
/*==============================================================*/
create table send
(
   order_id             varchar(255) not null,
   employee_id          varchar(25) not null,
   user_id              varchar(25) not null,
   send_time            datetime not null,
   re_real_time         datetime not null,
   user_address_no      varchar(25) not null,
   order_status         varchar(25) not null,
   primary key (order_id)
);

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   user_id              varchar(25) not null,
   user_name            varchar(25) not null,
   user_gen             varchar(1) not null,
   user_pwd             varchar(255) not null,
   user_tel             varchar(255) not null,
   user_city            varchar(255) not null,
   user_reg_time        datetime,
   is_vip               int not null,
   vip_end_time         datetime,
   primary key (user_id)
);

/*==============================================================*/
/* Table: user_sendplace                                        */
/*==============================================================*/
create table user_sendplace
(
   user_id              varchar(25) not null,
   use_user_id          varchar(25),
   user_address_no      varchar(255) not null,
   user_province        varchar(255) not null,
   user_city            varchar(255) not null,
   user_area            varchar(255) not null,
   user_place           varchar(255) not null,
   contacter            varchar(255) not null,
   contacter_tel        varchar(255) not null,
   primary key (user_id)
);

alter table coupons add constraint fk_coupons foreign key (mer_order_id)
      references merchandise_orders (order_id) on delete restrict on update restrict;

alter table employee_inform add constraint fk_manager foreign key (emp_employee_id)
      references employee_inform (employee_id) on delete restrict on update restrict;

alter table full_discount add constraint fk_relationship_3 foreign key (product_id)
      references product_infrom (product_id) on delete restrict on update restrict;

alter table merchandise_orders add constraint fk_coupons foreign key (coupons_id)
      references coupons (coupons_id) on delete restrict on update restrict;

alter table product_evaluation add constraint fk_product_evaluation foreign key (product_id)
      references product_recommendations (product_id) on delete restrict on update restrict;

alter table product_evaluation add constraint fk_product_evaluation foreign key (user_id)
      references user (user_id) on delete restrict on update restrict;

alter table product_infrom add constraint fk_relationship_2 foreign key (pro_id)
      references time_limited_promotional (pro_id) on delete restrict on update restrict;

alter table product_infrom add constraint fk_relationship_3 foreign key (discount_id)
      references full_discount (discount_id) on delete restrict on update restrict;

alter table recipe_evaluation add constraint fk_association_3 foreign key (recipe_id)
      references recipe_information (recipe_id) on delete restrict on update restrict;

alter table recipe_evaluation add constraint fk_association_3 foreign key (user_id)
      references user (user_id) on delete restrict on update restrict;

alter table time_limited_promotional add constraint fk_relationship_2 foreign key (product_id)
      references product_infrom (product_id) on delete restrict on update restrict;

alter table addition add constraint fk_pr foreign key (employee_id)
      references employee_inform (employee_id) on delete restrict on update restrict;

alter table addition add constraint fk_pr foreign key (product_id)
      references product_infrom (product_id) on delete restrict on update restrict;

alter table cook add constraint fk_cook foreign key (employee_id)
      references employee_inform (employee_id) on delete restrict on update restrict;

alter table cook add constraint fk_cook foreign key (order_id)
      references dishes (order_id) on delete restrict on update restrict;

alter table fedback add constraint fk_fedback foreign key (employee_id)
      references employee_inform (employee_id) on delete restrict on update restrict;

alter table fedback add constraint fk_fedback foreign key (order_id)
      references order_process_form (order_id) on delete restrict on update restrict;

alter table send add constraint fk_send foreign key (employee_id)
      references employee_inform (employee_id) on delete restrict on update restrict;

alter table send add constraint fk_send foreign key (order_id)
      references merchandise_orders (order_id) on delete restrict on update restrict;

alter table send add constraint fk_send foreign key (user_id)
      references user_sendplace (user_id) on delete restrict on update restrict;

alter table user_sendplace add constraint fk_relationship_6 foreign key (use_user_id)
      references user (user_id) on delete restrict on update restrict;

