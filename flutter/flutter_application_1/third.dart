future<void> main() async{
  print("start");
  String result=await fetchData();
  print(result);
  print("end");

}
// dart is a single thread language
// future is a way to handle asynchronous operations in dart
// future is used in api's, file operations, and other long-running tasks

Future<String> fetchData() async {
  print("fetching data");
  await Future.delayed(Duration(seconds: 4)); // Simulating network delay
  return "Data fetched successfully";
}