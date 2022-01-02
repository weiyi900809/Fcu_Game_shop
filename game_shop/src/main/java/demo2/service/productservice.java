
package demo2.service;

import demo2.database.Sql2oDbHandler;
import demo2.model.product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sql2o.Connection;

import java.util.List;

@Service
public class productservice {

    @Autowired
    private Sql2oDbHandler sql2oDbHandler;

    public productservice() {

    }

    public List<product> getProducts() {
        try (Connection connection = sql2oDbHandler.getConnector().open()) {
            String query = "select ID id, NAME name, ImageURL imageUrl, Price price, Description description"
                    + " from product";

            return connection.createQuery(query).executeAndFetch(product.class);

        }
    }


    public List<product> getProducts(String keyword) {
        try (Connection connection = sql2oDbHandler.getConnector().open()) {
            String query = "select ID id, Name name, ImageURL imageUrl, Price price, Description description"
                    + " from product where Name like :keyword";

            return connection.createQuery(query)
                    .addParameter("keyword", "%"+keyword+"%")
                    .executeAndFetch(product.class);

        }
    }
    public void addProducts( String Name, String ImageURL, int Price, String Description){
        String insertQuery =
                "INSERT INTO product (Name , ImageURL, Price , Description ) "

                        + "VALUES (:name, :imageURL, :price, :description)";
        try (Connection con = sql2oDbHandler.getConnector().open()) {
            con.createQuery(insertQuery)
                    .addParameter("name",Name )//account.getUName()
                    .addParameter("imageURL",ImageURL) //account.getPassword()
                    .addParameter("price",Price )//account.getUName()
                    .addParameter("description",Description) //account.getPassword()
                    .executeUpdate();
        }

    }


}
