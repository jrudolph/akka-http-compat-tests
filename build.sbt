val akkaHttpMasterLocalV = "10.1.11+137-272d3d15+20200325-1033"
val akka25LocalV = "2.5-SNAPSHOT"

lazy val root = project.in(file("."))
  .aggregate(library10_1_11_akka_2_5_30, userProject10_1_11_akka_2_6_3, userProjectAkkHttpNext_akka_2_5_30)

lazy val library10_1_11_akka_2_5_30 = project
  .settings(
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-http" % "10.1.11",
      "com.typesafe.akka" %% "akka-stream" % "2.5.30",
    )
  )

lazy val userProject10_1_11_akka_2_6_3 = project
  .dependsOn(library10_1_11_akka_2_5_30)
  .settings(
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-http" % "10.1.11",
      "com.typesafe.akka" %% "akka-stream" % "2.6.3",
      "com.typesafe.akka" %% "akka-actor-typed" % "2.6.3",
    )
  )

lazy val userProjectAkkHttpNext_akka_2_5_30 = project
  .dependsOn(library10_1_11_akka_2_5_30)
  .settings(
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-http" % akkaHttpMasterLocalV,
      "com.typesafe.akka" %% "akka-stream" % "2.5.30",
    )
  )

lazy val userProjectAkkHttpNext_akkaNext = project
  .dependsOn(library10_1_11_akka_2_5_30)
  .settings(
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-http" % akkaHttpMasterLocalV,
      "com.typesafe.akka" %% "akka-stream" % akka25LocalV,
      "com.typesafe.akka" %% "akka-actor-typed" % akka25LocalV,
    )
  )