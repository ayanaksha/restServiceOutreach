export SQL_DATABASE=fse
export SQL_USER=fse
export SQL_PASSWORD=Password123
if [[ -z "${SQL_CI_URL}" ]]; then
 export SQL_CI_URL=jdbc:oracle:thin:@fse.cm2iihhwewn5.us-east-2.rds.amazonaws.com:1433:fse
fi
