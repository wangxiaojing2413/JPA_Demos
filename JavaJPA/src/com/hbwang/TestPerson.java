package com.hbwang;

import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;

import javax.persistence.Persistence;


public class TestPerson {


	public static void main(String[] args) {

		// 实体管理工厂类 jpaDemo为配置文件中持久化单元名

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JavaJPA");

		// 尸体管理器

		EntityManager manager = factory.createEntityManager();

		// 开始事务

		manager.getTransaction().begin();

		// 持久化person对象

		manager.persist(new Person(1,"morris", 22));

		// 提交事务

		manager.getTransaction().commit();

		// 关闭资源

		manager.close();

		factory.close();

	}

}