# casestudy-2021-1

Die App liest eine CSV Datei aus Resources-Ordner ein und nutzt eine Hashtabelle,
um die Daten der Betriebsstellen zur Laufzeit abzuspeichern.
Somit kann mit O(1) die angefragte Betriebsstelle und ihre zusätzliche Informationen als eine JSON-Datei über die Restschnittstelle extrahiert werden.
Die Restschnittstelle hat die BASE_URL= "/betriebsstelle". Wird eine falsche Base-URL angegeben, so wird ein 404 FStatuscode ausgegeben.
Der Rest des Pfades soll den RL100-Code der Betriebsstelle kleingeschrieben eunthalten, dabei sind die Leerzeichen jeweils durch einen Unterstrich zu ersetzen.
So wird z.B. "BJF S" Betriebsstelle mit der URL "/betriebsstelle/bjf_s" angesprochen.
Die REST-Funktion gibt für eine unbekannte Betriebsstelle 404 Statuscode zurück und eine zusätzliche Ausgabe, dass keine Betriebsstelle mit dem entsprechenden Namen gefunden wurde."

#Set fields in application.properties:
-db.data.stations.resource.filename= DBNetz-Betriebsstellenverzeichnis-Stand2021-07.csv
-db.data.stations.resource.fileInResources = true

#JUnit Test
-für die Klasse CSVParser
