@ECHO OFF
del "c:\folder\uni\micro\ctcporta\ctcporta.map"
del "c:\folder\uni\micro\ctcporta\labels.tmp"
"C:\Program Files (x86)\Atmel\AVR Tools\AvrAssembler2\avrasm2.exe" -S "c:\folder\uni\micro\ctcporta\labels.tmp" -fI  -o "c:\folder\uni\micro\ctcporta\ctcporta.hex" -d "c:\folder\uni\micro\ctcporta\ctcporta.obj" -e "c:\folder\uni\micro\ctcporta\ctcporta.eep" -m "c:\folder\uni\micro\ctcporta\ctcporta.map" -W+ie   "C:\Folder\uni\micro\CTCPORTA\CTCPORTA.asm"
