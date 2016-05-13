/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SNMP;

import java.util.ArrayList;
import snmpup.SNMP4JHelper;
import utilities.classDisk;

/**
 *
 * @author Nataniel
 */
public class classSNMP {
    
    public classDisk consulta(String ipAddress, String numeroDeDiscoString){
        
            int numeroDeDisco = Integer.parseInt(numeroDeDiscoString); 
            
            if(numeroDeDisco<1){
                return null; 
            }
            //ipAddress="192.168.56.1"; 
            System.out.println(ipAddress);
            String Comunidad="clases";
            String OIDInicial="1.3.6.1.2.1.25.2.3.1";
            classDisk objectDisk = new classDisk(""); 
            //OIDInicial="1.3.6.1.2.1.2.2.1";
            String OID=SNMP4JHelper.snmpGetNextOID(ipAddress,Comunidad,OIDInicial);            
            int k=1,iteracion;
            //Se repetirá el ciclo hasta que ya no se obtengan más datos. 
            String tempString; 
            
            
            while(OID.contains(OIDInicial))
            {
                if(OID.contains(OIDInicial+".1")) 
                {                               
                    iteracion = 1;
                    while(OID.contains(OIDInicial+".1"))
                    {
                    	if(iteracion ==numeroDeDisco)
                    	{
	                        tempString = SNMP4JHelper.snmpGet(ipAddress,Comunidad, OID);
	                        objectDisk.StorageIndex = tempString; 
	                        OID=SNMP4JHelper.snmpGetNextOID(ipAddress,Comunidad,OID);	                        	                        

                    	}
                    	else{
                    		//Solo se incrementa el OID
                    		OID=SNMP4JHelper.snmpGetNextOID(ipAddress,Comunidad,OID);

                    	}
                    	iteracion++;
                    }

                }
                if(OID.contains(OIDInicial+".2")) 
                {                               
                    iteracion = 1;
                    while(OID.contains(OIDInicial+".2"))
                    {
                    	if(iteracion ==numeroDeDisco)
                    	{
	                        tempString = SNMP4JHelper.snmpGet(ipAddress,Comunidad, OID);
	                        objectDisk.StorageType = tempString; 
	                        OID=SNMP4JHelper.snmpGetNextOID(ipAddress,Comunidad,OID);	                        	                        

                    	}
                    	else{
                    		//Solo se incrementa el OID
                    		OID=SNMP4JHelper.snmpGetNextOID(ipAddress,Comunidad,OID);

                    	}
                    	iteracion++;
                    }

                }
                if(OID.contains(OIDInicial+".3")) 
                {                               
                    iteracion = 1;
                    while(OID.contains(OIDInicial+".3"))
                    {
                    	if(iteracion ==numeroDeDisco)
                    	{
	                        tempString = SNMP4JHelper.snmpGet(ipAddress,Comunidad, OID);
	                        objectDisk.StorageDescr = tempString; 
	                        OID=SNMP4JHelper.snmpGetNextOID(ipAddress,Comunidad,OID);	                        	                        

                    	}
                    	else{
                    		//Solo se incrementa el OID
                    		OID=SNMP4JHelper.snmpGetNextOID(ipAddress,Comunidad,OID);

                    	}
                    	iteracion++;
                    }

                }
                if(OID.contains(OIDInicial+".4")) 
                {                               
                    iteracion = 1;
                    while(OID.contains(OIDInicial+".4"))
                    {
                    	if(iteracion ==numeroDeDisco)
                    	{
	                        tempString = SNMP4JHelper.snmpGet(ipAddress,Comunidad, OID);
	                        objectDisk.StorageAllocationUnits = Long.parseLong(tempString); 
	                        OID=SNMP4JHelper.snmpGetNextOID(ipAddress,Comunidad,OID);	                        	                        

                    	}
                    	else{
                    		//Solo se incrementa el OID
                    		OID=SNMP4JHelper.snmpGetNextOID(ipAddress,Comunidad,OID);

                    	}
                    	iteracion++;
                    }

                }
                if(OID.contains(OIDInicial+".5")) 
                {                               
                    iteracion = 1;
                    while(OID.contains(OIDInicial+".5"))
                    {
                    	if(iteracion ==numeroDeDisco)
                    	{
	                        tempString = SNMP4JHelper.snmpGet(ipAddress,Comunidad, OID);
	                        objectDisk.StorageSize = Long.parseLong(tempString); 
	                        OID=SNMP4JHelper.snmpGetNextOID(ipAddress,Comunidad,OID);	                        	                        

                    	}
                    	else{
                    		//Solo se incrementa el OID
                    		OID=SNMP4JHelper.snmpGetNextOID(ipAddress,Comunidad,OID);

                    	}
                    	iteracion++;
                    }

                }   
                
                if(OID.contains(OIDInicial+".6")) 
                {                               
                    iteracion = 1;
                    while(OID.contains(OIDInicial+".6"))
                    {
                    	if(iteracion ==numeroDeDisco)
                    	{
	                        tempString = SNMP4JHelper.snmpGet(ipAddress,Comunidad, OID);
	                        objectDisk.StorageUsed = Long.parseLong(tempString); 
	                        OID=SNMP4JHelper.snmpGetNextOID(ipAddress,Comunidad,OID);	                        	                        

                    	}
                    	else{
                    		//Solo se incrementa el OID
                    		OID=SNMP4JHelper.snmpGetNextOID(ipAddress,Comunidad,OID);

                    	}
                    	iteracion++;
                    }

                }
                
                if(OID.contains(OIDInicial+".7")) 
                {                               
                    iteracion = 1;
                    while(OID.contains(OIDInicial+".7"))
                    {
                    	if(iteracion ==numeroDeDisco)
                    	{
	                        tempString = SNMP4JHelper.snmpGet(ipAddress,Comunidad, OID);
	                        objectDisk.StorageAllocationFailures = Long.parseLong(tempString); 
	                        OID=SNMP4JHelper.snmpGetNextOID(ipAddress,Comunidad,OID);	                        	                        

                    	}
                    	else{
                    		//Solo se incrementa el OID
                    		OID=SNMP4JHelper.snmpGetNextOID(ipAddress,Comunidad,OID);

                    	}
                    	iteracion++;
                    }

                }
                
                
                            
            /*
                    */
                        
    }
            
            //Recalculo de valores 
            objectDisk.StorageSize = objectDisk.StorageSize*objectDisk.StorageAllocationUnits/1024/1024/1024;            
            objectDisk.StorageUsed = objectDisk.StorageUsed * objectDisk.StorageAllocationUnits/1024/1024/1024;             
                
            return objectDisk; 
}
}
    

    

