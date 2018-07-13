import com.reus.example.Patient
import java.io.StringReader
import java.io.StringWriter
import javax.xml.bind.JAXBContext

fun main(args: Array<String>) {
    var context = JAXBContext.newInstance(Patient::class.java)
    val marshaller = context.createMarshaller()

    val patient = Patient()
    patient.id = 1
    patient.name = "Reus"
    var stringWriter = StringWriter()
    marshaller.marshal(patient, stringWriter)
    println(stringWriter)

    val unmarshaller = context.createUnmarshaller()
    val unmarshalledPatient = unmarshaller.unmarshal(StringReader(stringWriter.toString())) as Patient
    println("Patient: id: ${unmarshalledPatient.id} name: ${unmarshalledPatient.name}")
}