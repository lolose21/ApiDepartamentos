package repositories;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Departamento;

public class RepositoryDepartamento {

    private Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new SQLServerDriver());
        String cadena
                = "jdbc:sqlserver://sqlserverjavaisma.database.windows.net:1433;databaseName=SQLAZURE";
        Connection cn = DriverManager.getConnection(cadena, "admiinsql", "Admin123");
        return cn;
    }

    public List<Departamento> getDepartamentos() throws SQLException {
        Connection cn = this.getConnection();
        String sql = "select * from dept";
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        ArrayList<Departamento> departamentos = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("DEPT_NO");
            String nombre = rs.getString("DNOMBRE");
            String localidad = rs.getString("LOC");
            Departamento departamento = new Departamento(id, nombre, localidad);
            departamentos.add(departamento);
        }
        rs.close();
        cn.close();
        return departamentos;
    }

    public Departamento getDepartamentoNo(int deptno) throws SQLException {

        Connection cn = this.getConnection();
        String sql = "select * from dept where dept_no=?";
        PreparedStatement pst = cn.prepareStatement(sql);
        pst.setInt(1, deptno);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            int id = rs.getInt("DEPT_NO");
            String nombre = rs.getString("DNOMBRE");
            String localidad = rs.getString("LOC");
            Departamento departamento = new Departamento(id, nombre, localidad);
            rs.close();
            cn.close();
            return departamento;
        } else {
            rs.close();
            cn.close();
            return null;
        }
    }

}
