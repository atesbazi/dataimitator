(ns dataimitator.animal.fishes)

(def fish-species
  {:ar ["سمك السلمون" "سمكة التشري" "البونيتو الأطلسي" "السمك الأحمر المتوسطي" "السردين الأوروبي"
        "سمك الدوري" "الدنتكس" "سمك القتال السيامي" "الموري" "سمك الباس"
        "السارجو" "سمك السوم" "المولي" "سمك الوحل" "الدندكس" "البوري" "الحريش" "سمك التجمع"
        "البلوفيش" "المرجان الأحمر" "البوب" "مورميد" "سمك الأمبرجاك" "اللولو" "سمك البوربوت" "شاد"
        "جمبري" "سلطعون الطين" "الأخطبوط" "الحبار" "سرطان البحر" "أنشوفة" "سمك الفضة" "الحوت"
        "الأسماك الفضية" "الحبار" "سمك الرمادي" "السردين" "سمك السيف" "السلمون" "البونيتو" "الأحمر"
        "الكاراسيوس" "السمك الذهبي" "السمك القط" "الحوت" "الرود"]
   :de ["Forelle" "Goldbrasse" "Bonito" "Mittelmeer-Rote Meerbarbe" "Europäische Sardine"
        "Goldbrasse" "Zahnbrasse" "Kampffisch" "Weißer Zackenbarsch" "Europäischer Wolfsbarsch"
        "Sargo" "Wels" "Wittling" "Seezunge" "Dusky Grouper" "Meeräsche" "Hering" "Hecht"
        "Gemeinsame Pandora" "Blauer Fisch" "Rotes Korallen" "Boops boops" "Mormyrid" "Bernsteinfisch" "Flunder" "Schad"
        "Garnele" "Schlammkrabbe" "Tintenfisch" "Kalmare" "Hummer" "Anchovis" "Silberfisch" "Aal" "Makrele"
        "Garnelen" "Graue Meeräsche" "Sardine" "Schwertfisch" "Forelle" "Bonito" "Knurrhahn" "Karausche" "Karpfen"
        "Wels" "Tench" "Brassen" "Rotaugen"]
   :en ["Trout" "Gilt-head bream" "Atlantic bonito" "Mediterranean red mullet" "European pilchard"
        "Gilthead sea bream" "Dentex" "Siamese fighting fish" "White grouper" "European sea bass"
        "Sargo" "Poplar glanis" "Whiting" "Common sole" "Dusky grouper" "Mullet" "Herring" "Hake"
        "Common pandora" "Bluefish" "Red coral" "Boops boops" "Mormyrid" "Amberjack" "Burbot" "Shad"
        "Shrimp" "Mud crab" "Octopus" "Squid" "Lobster" "Anchovy" "Silver fish" "Eel" "Horse mackerel"
        "Shrimp" "Gray mullet" "Sardine" "Swordfish" "Trout" "Bonito" "Gurnard" "Carassius" "Carp"
        "Catfish" "Tench" "Bream" "Rudd"]
   :es ["Trucha" "Dorada" "Bonito" "Salmonete mediterráneo" "Sardina europea"
        "Dorada grise" "Dentex" "Pez luchador de Siam" "Mero blanco" "Lubina europea"
        "Sargo" "Siluro" "Pescadilla" "Suela común" "Mero bronceado" "Salmonete" "Arenque" "Merluza"
        "Pandora común" "Pez azul" "Coral rojo" "Boops boops" "Mormirido" "Jurel" "Bacalao" "Saboga"
        "Gamba" "Cangrejo de barro" "Pulpo" "Calamar" "Langosta" "Anchoa" "Pez plateado" "Anguila" "Jurel"
        "Calamar" "Mújol" "Sardina" "Pez espada" "Trucha" "Bonito" "Rubio" "Carassius" "Carpa"
        "Bagre" "Tenca" "Brema" "Rutilo"]
   :fr ["Truite" "Dorade royale" "Thon" "Rouget méditerranéen" "Sardine européenne"
        "Dorade grise" "Dentex" "Combattant de Siam" "Mérou blanc" "Bar européen"
        "Sparus aurata" "Silure glane" "Merlan" "Sole commune" "Mérou bronzé" "Mulet" "Hareng" "Merlu"
        "Pagellus erythrinus" "Poisson bleu" "Corail rouge" "Boops boops" "Mormyridé" "Sériole" "Lotte" "Alose"
        "Crevette" "Crabe boueux" "Poulpe" "Calmar" "Homard" "Anchois" "Poisson argenté" "Anguille" "Maquereau"
        "Crevette" "Mulet gris" "Sardine" "Espadon" "Truite" "Bonite" "Grondin" "Carassin" "Carpe"
        "Silure" "Tanche" "Brème" "Rotengle"]
   :tr ["Alabalık" "Akya" "Bakalyaro" "Barbunya-Tekir" "Berlam-Mirlan" "Çipura" "Dil" "Pisi" "Dülger" "Levrek" "Fener"
        "Gelincik" "Mezgit" "Kalkan" "Karagöz" "Kefal" "Kırlangıç" "Kupez" "Lagos" "Lüfer" "Mercan" "Mırmır" "Orfoz"
        "Sinarit-Trança" "Sudak" "Turna" "Yayın" "Karides" "Sübye" "Ahtapot" "Kalamar" "İstakoz" "Pavurya" "Hamsi"
        "Gümüş" "Yılanbalığı" "İstavrit" "İzmarit" "Uskumru" "Kolyoz" "Somon" "Sardalya" "Kılıç Balığı" "Alabalık"
        "Palamut" "Torik" "Tirsi" "Zargana" "Sazan" "Yılan"]})

(defn random-fish
  "Generates a random fish species name in the specified language.
   Supported languages: :ar, :de, :en, :es, :fr, :tr
   Defaults to :en if no language is specified."
  ([] (random-fish :en))
  ([language]
   (let [lang (if (keyword? language) (name language) language)
         names (get fish-species (keyword lang))]
     (if names
       (rand-nth names)
       (throw (IllegalArgumentException. (str "Unsupported language: " language)))))))