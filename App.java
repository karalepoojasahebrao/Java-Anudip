package com.anudip.BuyGiftCardProject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;




public class App 
{
   public static void main( String[] args )
        { 
	   Configuration conf= new Configuration().configure().addAnnotatedClass(Item.class).addAnnotatedClass(Order.class).addAnnotatedClass(Card.class);   //create configuration with annotated class
        SessionFactory ss=conf.buildSessionFactory();
        Session s = ss.openSession();
        Transaction t=s.beginTransaction();
        
          Item i1=new Item(1,"Electronics","RelianceDigital",500,10,"Excellent");
          Item i2=new Item(2,"Fashion & LifeStyle","Lifestyle",450,5,"Better");
          
         Order o1=new Order();
         o1.setOrderid(1);
         o1.setName("Pooja");
         o1.setEmail("Pooja@gmail.com ");
         o1.setMobileno("7684855769");
         o1.setPaymentmethod("Online");
          Card c1=new Card(101,"SBI","Pooja Karale",431257);
             
          
          List<Item> list=new ArrayList<>();
          list.add(i1);
          list.add(i2);
        o1.setitem(list);
          
        s.save(i1);
        s.save(i2);
        s.save(o1);
        s.save(c1);
        t.commit();
        
        ss.close();
             System.out.println( "Hello World!" );
        }
       
  }
