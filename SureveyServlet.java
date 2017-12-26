package responseCollector;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class SureveyServlet
 */
@WebServlet("/surevey")
public class SureveyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final int numParams=16;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SureveyServlet() {
        super();
        
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String teamName=request.getParameter("teamName");
		String techs=request.getParameter("techs");
		String usualTime=request.getParameter("usualTime");
		String numHours=request.getParameter("numHours");
		String nature=request.getParameter("nature");
		String pressure=request.getParameter("pressure");
		String proj=request.getParameter("proj");
		String contrib=request.getParameter("contrib");
		String day=request.getParameter("day");
		String perk=request.getParameter("perk");
		String cons=request.getParameter("cons");
		String support=request.getParameter("support");
		String teamRating=request.getParameter("teamRating");
		
		ArrayList<String> newEntryParams=new ArrayList<String>();
		
		newEntryParams.add(name);
		newEntryParams.add(soeid);
		newEntryParams.add(lob);
		newEntryParams.add(teamName);
		newEntryParams.add(techs);
		newEntryParams.add(usualTime);
		newEntryParams.add(numHours);
		newEntryParams.add(nature);
		newEntryParams.add(pressure);
		newEntryParams.add(proj);
		newEntryParams.add(contrib);
		newEntryParams.add(day);
		newEntryParams.add(perk);
		newEntryParams.add(cons);
		newEntryParams.add(support);
		newEntryParams.add(teamRating);
		
		//to print new entry on console
		StringBuilder sb=new StringBuilder();
		sb.append("______________________________________________\n");
		sb.append("New Entry:\n");
		sb.append("Name : "+name+"\n");
		sb.append("Team : "+teamName+"\n");
		sb.append("Techs : "+techs+"\n");
		sb.append("Usual Time : "+usualTime+"\n");
		sb.append("numHours : "+numHours+"\n");
		sb.append("Nature of Work : "+nature+"\n");
		sb.append("Work Pressure : "+pressure+"\n");
		sb.append("Project Details : "+proj+"\n");
		sb.append("Their Contribution : "+contrib+"\n");
		sb.append("Typical Day : "+day+"\n");
		sb.append("Perks : "+perk+"\n");
		sb.append("Cons : "+cons+"\n");
		sb.append("Remarks : "+support+"\n");
		sb.append("Overall Rating : "+teamRating+"\n");
		sb.append("______________________________________________");
		
		System.out.println(sb.toString());
		
		//to save entry in csv
		/*Each entry is enclosed in quotes, so that the commas inside the string variables do not separate the csv cells*/
		StringBuilder csvSB = new StringBuilder();
		csvSB.append("\"").append(name).append("\",");
		csvSB.append("\"").append(teamName).append("\",");
		csvSB.append("\"").append(techs).append("\",");
		csvSB.append("\"").append(usualTime).append("\",");
		csvSB.append("\"").append(numHours).append("\",");
		csvSB.append("\"").append(nature).append("\",");
		csvSB.append("\"").append(pressure).append("\",");
		csvSB.append("\"").append(proj).append("\",");
		csvSB.append("\"").append(contrib).append("\",");
		csvSB.append("\"").append(day).append("\",");
		csvSB.append("\"").append(perk).append("\",");
		csvSB.append("\"").append(cons).append("\",");
		csvSB.append("\"").append(support).append("\",");
		csvSB.append("\"").append(teamRating).append("\"");
		
		
		try{			
			
			String csvName="responses.csv";
			
			File f = new File(csvName);
			
			PrintWriter toFile = new PrintWriter(new BufferedWriter(new FileWriter(f, true)));
			toFile.println(csvSB.toString());
			toFile.close();		
			
			System.out.println("Sent to csv: "+csvSB.toString());
			System.out.println("writing to "+f.getAbsolutePath());
			String confirmation = "Thank you "+name+", for your feedback.\n\rYou may now close this tab";
			PrintWriter out=response.getWriter();
			out.println(confirmation);
			System.out.println("Entry added");
			
		}catch (FileNotFoundException e) {
			System.out.println("File not found "+e);
		} catch(IOException e) {
			System.out.println("IO Exception "+e);
		}
	}

}
