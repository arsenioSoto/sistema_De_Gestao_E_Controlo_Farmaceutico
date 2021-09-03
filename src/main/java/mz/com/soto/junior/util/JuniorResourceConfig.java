package mz.com.soto.junior.util;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

//http://localhost:8081/Junior/[NomeRest]
@ApplicationPath("rest")
public class JuniorResourceConfig extends ResourceConfig {
	
	public JuniorResourceConfig() {
		packages("mz.com.soto.junior.service");
	}
}
