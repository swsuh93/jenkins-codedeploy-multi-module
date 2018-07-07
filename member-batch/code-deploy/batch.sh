ORIGIN_JAR=$(readlink /home/jenkins/member-batch/application.jar)
echo "	> ORIGIN_JAR: ${ORIGIN_JAR}"
java -jar ${ORIGIN_JAR} \
--job.name=sampleBatch \
version=${version}