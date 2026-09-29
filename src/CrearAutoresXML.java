import java.io.FileWriter;
import java.io.IOException;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

public class CrearAutoresXML {

    public static void main(String[] args) {
        // Nome do ficheiro XML a crear
        String nomeFicheiro = "autores.xml";

        try {
            // 1. Crear unha instancia de XMLOutputFactory
            XMLOutputFactory factory = XMLOutputFactory.newInstance();

            // 2. Crear o obxecto XMLStreamWriter a partir dun FileWriter
            FileWriter fileWriter = new FileWriter(nomeFicheiro);
            XMLStreamWriter writer = factory.createXMLStreamWriter(fileWriter);

            // 3. Escribir a declaración XML (versión 1.0)
            writer.writeStartDocument("1.0");

            // 4. Elemento raíz: <autores>
            writer.writeStartElement("autores");

            // --- PRIMEIR AUTOR: Alexandre Dumas ---
            writer.writeStartElement("autor");

            writer.writeStartElement("nome");
            writer.writeCharacters("Alexandre Dumas");
            writer.writeEndElement(); // </nome>

            writer.writeStartElement("obras");

            writer.writeStartElement("obra");
            writer.writeCharacters("El conde de montecristo");
            writer.writeEndElement(); // </obra>

            writer.writeStartElement("obra");
            writer.writeCharacters("Los miserables");
            writer.writeEndElement(); // </obra>

            writer.writeEndElement(); // </obras>
            writer.writeEndElement(); // </autor>

            // --- SEGUNDO AUTOR: Fiodor Dostoyevski ---
            writer.writeStartElement("autor");

            writer.writeStartElement("nome");
            writer.writeCharacters("Fiodor Dostoyevski");
            writer.writeEndElement(); // </nome>

            writer.writeStartElement("obras");

            writer.writeStartElement("obra");
            writer.writeCharacters("El idiota");
            writer.writeEndElement(); // </obra>

            writer.writeStartElement("obra");
            writer.writeCharacters("Noches blancas");
            writer.writeEndElement(); // </obra>

            writer.writeEndElement(); // </obras>
            writer.writeEndElement(); // </autor>

            // Pechar o elemento raíz </autores>
            writer.writeEndElement();

            // Finalizar e pechar o documento
            writer.writeEndDocument();
            writer.flush();
            writer.close();

            System.out.println("O ficheiro '" + nomeFicheiro + "' foi creado con éxito.");

        } catch (IOException e) {
            System.err.println("Erro de E/S ao crear o ficheiro: " + e.getMessage());
        } catch (XMLStreamException e) {
            System.err.println("Erro ao xerar o documento XML: " + e.getMessage());
        }
    }
}