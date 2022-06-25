open module com.example.bd {
    requires org.hibernate.orm.core;
    requires java.persistence;
    requires java.sql;

    exports com.example.bd.BLL;
    exports com.example.bd.DAL;
}