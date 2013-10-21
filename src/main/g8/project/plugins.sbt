addSbtPlugin("io.spray" % "sbt-revolver" % "0.7.1")

addSbtPlugin("org.scalastyle" %% "scalastyle-sbt-plugin" % "0.3.2")

addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.9.2")

addSbtPlugin("reaktor" % "sbt-scct" % "0.2-SNAPSHOT")

resolvers += "sonatype-releases" at "https://oss.sonatype.org/content/repositories/releases/"

resolvers += "scct-github-repository" at "http://mtkopone.github.com/scct/maven-repo"
