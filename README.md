# Dungeon Crawler Deluxe Maps

Maps haben eine Größe von 20x20 teilen. Es können beliebig viele Maps im Ordner resources/maps angelegt werden, dabei muss nur auf eine durchgängige Nummerierung geachtet werden.

Sollte die Anzahl an Maps geändert werden, muss außerdem die statische Variable maxLevel in der Map Klasse angepasst werden.

# Dungeon Crawler Deluxe Tiles

Jeder Buchstabe in der Mapdatei wird durch eine Grafik ersetzt. Folgende Tiles sind verfügbar:

* 0 - Eingang
* x - Ausgang
* w - Wasser, nicht begehbar (ACHTUNG: Jede Map muss mit Wasser eingerahmt werden!)
* s - Sand, begehbar
* g - Gras, begehbar
* e - Gegner, tödlich

# TO DO

* win() und lose() in Map
