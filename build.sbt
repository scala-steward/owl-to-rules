
organization  := "org.geneontology"

name          := "owl-to-rules"

version       := "0.3.6"

publishMavenStyle := true

publishTo := {
    val nexus = "https://oss.sonatype.org/"
    if (isSnapshot.value)
        Some("snapshots" at nexus + "content/repositories/snapshots")
    else
        Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

publishArtifact in Test := false

licenses := Seq("BSD-3-Clause" -> url("https://opensource.org/licenses/BSD-3-Clause"))

homepage := Some(url("https://github.com/balhoff/owl-to-rules"))

scalaVersion  := "2.12.8"

crossScalaVersions := Seq("2.11.12", "2.12.8")

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

scalacOptions in Test ++= Seq("-Yrangepos")

javaOptions in Test += s"""-Djava.library.path=${baseDirectory.value / "native"}"""

fork in Test := true

libraryDependencies ++= {
  Seq(
    "net.sourceforge.owlapi"      %  "owlapi-distribution"    % "4.2.7",
    "org.apache.jena"             %  "apache-jena-libs"       % "3.1.1" pomOnly(),
    "org.phenoscape"              %% "scowl"                  % "1.3.4",
    "com.typesafe.scala-logging"  %% "scala-logging"          % "3.9.2",
    "ch.qos.logback"              %  "logback-classic"        % "1.2.3",
    "org.codehaus.groovy"         %  "groovy-all"             % "2.4.6",
    "net.sourceforge.owlapi"      %  "org.semanticweb.hermit" % "1.3.8.413" % Test,
    "org.scalatest"               %% "scalatest"              % "3.0.8" % Test
  )
}

pomExtra := (
    <scm>
        <url>git@github.com:balhoff/owl-to-rules.git</url>
        <connection>scm:git:git@github.com:balhoff/owl-to-rules.git</connection>
    </scm>
    <developers>
        <developer>
            <id>balhoff</id>
            <name>Jim Balhoff</name>
            <email>jim@balhoff.org</email>
        </developer>
    </developers>
)
