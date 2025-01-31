class Tank(
    hp: Int,
    manaOrRecource: Int,
    strg: Double,
    int: Double,
    agi: Double,
    pDef: Int,
    mDef: Int,
    name: String,
    threat: Int,
    dotActive: Boolean
) : Hero(
    hp,
    manaOrRecource,
    strg,
    int,
    agi,
    pDef,
    mDef,
    name,
    threat,
    dotActive
) {
    override fun tankAction1() { // threat increase Ability
        val attackName = "Taunt"
        threat += 100 // setzt threat des Heros auf 100
        manaOrRecource += 15 // erhöht die Wut des Characters um 15 nach einsetzten der Ability
        println("$name setzt $attackName ein und erhöht seinen threat auf 100!")
        println("$name´s Wut steigt um 15 und beträgt nun ${manaOrRecource}")
    }

    override fun tankActiion2() { //Heal def cd Ability
        val attackName = "Last man standing"
        if (hp < 2500 || manaOrRecource == 80) { //bedingung zum einsetzten der Ability ist dass der Hero weniger als 2,5k hp hat und mehr als 50 Wut
            hp = 7800 // setzt die HP des Heros auf den festgelegten Wert
            println("$name setzt $attackName ein um sich wieder auf 100% zu heilen")
            manaOrRecource - 50 // verbraucht Wut als recource
            threat += 15
        } else {
            println("Du hast nicht genügend Schaden erlitten oder nicht genung Wut um diese Ability einzusetzten!")
        }
    }

    override fun tankAction3(): Double { //Simple damage Ability mit Strengh Multiplikator
        val attackName = "Heroic Strike"
        var heroicStrike = 15..18
        var dmg = heroicStrike.random().toDouble() * strg
        manaOrRecource += 15
        threat += 20
        println("$name setzt $attackName ein und fügt Ragnaros $dmg zu")
        return dmg
    }

    override fun tankAction4(): Double { // AE Ability (Area Effect) die dmg verursacht mit agi und int Multiplikator
        val attackName = "Thunderclap"
        var thunderclap = 1..2
        var dmg = thunderclap.random().toDouble() * agi * int
        manaOrRecource += 20 // erhöht den threat des Heros um 20
        threat += 35
        println("$name setzt $attackName ein verursacht damit $dmg. Seine Bedrohung wurde um 35 erhöht")
        return dmg
    }

    override fun useInventory() {
        println(
            """
            Welchen Trank möchtest du benutzen?
            1 -> Health Potion (erhöht deine Lebenspunkte permanent um 500)
            2 -> STRG Potion (erhöht deine Stärke permanent um 50)
            3 -> AGI Potion (erhöht deine Beweglichkeit permanent um 50)
            4 -> INT Potion (erhöht deine Intelligenz permanent um 50)
            Nach benutzung eines Trankes verschwindet dieser aus deinem Inventar!
        """.trimIndent()
        )
        var input = readln().toIntOrNull()
        when (input) {
            1 -> {
                if ("Health Potion" in inventoryList) {
                    println(
                        """
                        $name hat seine Lebenspunkte permanent um 500 erhöht!
                        -------------------------------------------------------------------------------------------------------------------------------------------------------
                    """.trimIndent()
                    )
                    hp += 500
                    inventoryList.remove("Health Potion")
                } else println("Keine Health Potions mehr übrig...")

            }

            2 -> {
                if ("STRG Potion" in inventoryList) {
                    println(
                        """
                        $name hat seine Stärke permanent um 50 erhöht!
                        -------------------------------------------------------------------------------------------------------------------------------------------------------
                    """.trimIndent()
                    )
                    strg += 50
                    inventoryList.remove("STRG Potion")
                } else println("Keine STRG Potions mehr übrig...")

            }

            3 -> {
                if ("AGI Potion" in inventoryList) {
                    println(
                        """
                        $name hat seine Beweglichkeit permanent um 50 erhöht!
                        -------------------------------------------------------------------------------------------------------------------------------------------------------
                    """.trimIndent()
                    )
                    agi += 50
                    inventoryList.remove("AGI Potion")
                } else println("Keine AGI Potions mehr übrig...")
            }

            4 -> {
                if ("INT Potion" in inventoryList) {
                    println(
                        """
                        $name hat seine Intelligenz permanent um 50 erhöht!
                        -------------------------------------------------------------------------------------------------------------------------------------------------------
                    """.trimIndent()
                    )
                    int += 50
                    inventoryList.remove("INT Potion")
                } else println("Keine INT Potions mehr übrig...")

            }

            else -> {
                println("Ungültige Eingabe!")
            }
        }

    }
}