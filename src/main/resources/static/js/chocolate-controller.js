angular.module("ChocolateMakerApp",[])
    .controller("ChocolateController", function($scope,$http,$timeout){
        $scope.finishedChocolate;
        $scope.container = {};
        console.log("Testing....");

        $scope.makeArray = function(arraySize) {
            var returnArray = [];
            for (var i = 0; i < arraySize; i++) {
                returnArray.push(i);
            }
            return returnArray;
        };

        $scope.solveChocolate = function(numSmalls, numBigs, goal){
            console.log("About to make chocolate");
            $http.get("/chocolate.json?numSmall=" + $scope.container.numSmalls + "&numBig=" + $scope.container.numBigs + "&goal=" + $scope.container.goal)
                .then(
                    function success(response){
                            console.log(response.data);
                            console.log("Adding data to scope");
                            $scope.finishedChocolate = response.data;
                            console.log($scope.finishedChocolate);
                            if($scope.finishedChocolate.hasSolution == true){
                                    $scope.container.numSmalls = $scope.container.numSmalls - $scope.finishedChocolate.smalls;
                                    $scope.container.numBigs = $scope.container.numBigs - $scope.finishedChocolate.bigs;
                            }
                    },
                    function error(response){
                            console.log("Unable to get data");
                    });
        };

    });


