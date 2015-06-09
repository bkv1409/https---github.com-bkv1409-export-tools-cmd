Guild run cmd tool
1. need require java 7 or higher
2. base command run
java -cp "exportExcel-1.0-SNAPSHOT.jar;lib/*" com.dc.utils.Run

show help
java -cp "exportExcel-1.0-SNAPSHOT.jar;lib/*" com.dc.utils.Run -h
3. args for command
-i path_to_file_or_folder
(duong dan de thu muc input, co the la thu muc chua file XML hoac 1 file XML cu the, mac dinh la thu muc xmls)
-o path_to_output_folder
(duong dan den thu thu output export ra reprot, mac dinh la exports)

Example:
* default command
java -cp "exportExcel-1.0-SNAPSHOT.jar;lib/*" com.dc.utils.Run

* custumize command
java -cp "exportExcel-1.0-SNAPSHOT.jar;lib/*" com.dc.utils.Run -i C:\input -o C:\output
4. Dat ten file out put
ten file co cau truc 
DataExport_yyMMdd_hhmmssss.xlsx
Example:
DataExport_150512_07200051.xlsx