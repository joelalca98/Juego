package edu.upc.dsa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class Covid19ManagerTest {
    @Before
    public void SetUp(){
        Covid19ManagerImpl.getInstance().añadePersona("persona1","Kevin","Alcalde",24,"A");
        Covid19ManagerImpl.getInstance().añadePersona("persona2","Hola","Alcalde",24,"B");
        Covid19ManagerImpl.getInstance().añadePersona("persona3","Joel","Alcalde",23,"C");
        Covid19ManagerImpl.getInstance().añadePersona("persona4","Hola","Alcalde",22,"B");
        Covid19ManagerImpl.getInstance().procesarMuestra("positivo","ANIMO");
        Covid19ManagerImpl.getInstance().añadeMuestra("muestra1","clinico1","persona1",new Date(2020,07,20),"lab1");
        Covid19ManagerImpl.getInstance().añadeMuestra("muestra2","clinico2","persona1",new Date(2020,07,20),"lab1");
        Covid19ManagerImpl.getInstance().añadeMuestra("muestra3","clinico3","persona1",new Date(2020,07,20),"lab1");



    }

    @Test
    public void CrearPersona(){

        Covid19ManagerImpl.getInstance().añadePersona("persona5","Holi","Alcalde",34,"C");
        assertEquals(5, Covid19ManagerImpl.getInstance().sizePersonas());


    }


    @Test
    public void ProcesarOrden(){
        Covid19ManagerImpl.getInstance().procesarMuestra("negativo","BIEN");
        assertEquals(3, Covid19ManagerImpl.getInstance().sizeMuestrasProcesadas());




    }




    @After
    public void tearDown() { Covid19ManagerImpl.getInstance().delete();}


}
